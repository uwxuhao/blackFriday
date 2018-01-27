package com.shopping.blackfriday.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.blackfriday.dto.*;
import com.shopping.blackfriday.entity.Product;
import com.shopping.blackfriday.entity.User;
import com.shopping.blackfriday.exception.NoSuchProductException;
import com.shopping.blackfriday.exception.NoSuchUserException;
import com.shopping.blackfriday.service.ProductService;
import com.shopping.blackfriday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@EnableWebMvc
@RequestMapping("/blackFriday")
public class BlackFridayController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getProductList(Model model) {
        System.out.println("get into list");
        List<Product> list = productService.getAllProducts();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value = "/{productId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("productId") Long productId, Model model) {
        if (productId == null) return "redirect:/blackFriday/list";
        try {
            Product product = productService.getProductById(productId);
            model.addAttribute("product", product);
            return "detail";
        } catch (NoSuchProductException e) {
            return "redirect:/blackFriday/list";
        }
    }

    @RequestMapping(value = "/{productId}/info", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ServerResponse<ShoppingInfo> getShoppingInfo(@PathVariable("productId") Long productId) {
        ShoppingInfo shoppingInfo = productService.getShoppingInfo(productId);
        return new ServerResponse<ShoppingInfo>(shoppingInfo, true, "successful");
    }

    @RequestMapping(value = "/{productId}/{userId}/{num}/{md5}/request", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ServerResponse<RequestResult> getRequestResult(@PathVariable("productId") Long productId, @PathVariable("userId") long userId, @PathVariable("num") int requestNum, @PathVariable("md5") String md5) {
        RequestResult requestResult = productService.doShopping(productId, userId, requestNum, md5);
        return new ServerResponse<RequestResult>(requestResult, true, "success");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(@RequestBody LoginInfo loginInfo, HttpSession session) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String userName = loginInfo.getUserName();
            String password = loginInfo.getPassword();
            boolean valid = userService.validUser(userName, password);
            if (valid) {
                User user = userService.getUserByUserName(userName);
                userService.login(user.getUserId());
                session.setAttribute("userName", userName);
                ResponseUser responseUser = new ResponseUser(user.getUserId(), userName, user.getEmail(), user.getBalance());
                ServerResponse<ResponseUser> serverResponse = new ServerResponse<ResponseUser>(responseUser, true, "success");
                String jsonString = objectMapper.writeValueAsString(serverResponse);
                return jsonString;
            } else {
                String jsonString = objectMapper.writeValueAsString(new ServerResponse<ResponseUser>(false, "Please enter the correct password"));
                return jsonString;
            }
        } catch (NoSuchUserException e) {
            try {
                String jsonString = objectMapper.writeValueAsString(new ServerResponse<ResponseUser>(false, "No user match for user name: " + loginInfo.getUserName()));
                return jsonString;
            } catch (JsonProcessingException jsonException) {
                jsonException.printStackTrace();
                return "";
            }
        } catch (JsonProcessingException jsonException) {
            jsonException.printStackTrace();
            return "";
        }
    }
}
