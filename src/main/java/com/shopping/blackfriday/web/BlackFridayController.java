package com.shopping.blackfriday.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.blackfriday.dto.*;
import com.shopping.blackfriday.entity.Product;
import com.shopping.blackfriday.exception.NoSuchProductException;
import com.shopping.blackfriday.exception.NoSuchUserException;
import com.shopping.blackfriday.service.ProductService;
import com.shopping.blackfriday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blackFriday")
public class BlackFridayController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getProductList(Model model) {
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
    public String getShoppingInfo(@PathVariable("productId") Long productId) {
        ShoppingInfo shoppingInfo = productService.getShoppingInfo(productId);
        ServerResponse<ShoppingInfo> serverResponse = new ServerResponse<ShoppingInfo>(shoppingInfo, true, "success");
        return convertResponseToString(serverResponse);
    }

    @RequestMapping(value = "/{productId}/{userId}/{num}/{md5}/request", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getRequestResult(@PathVariable("productId") Long productId, @PathVariable("userId") long userId, @PathVariable("num") int requestNum, @PathVariable("md5") String md5) {
        RequestResult requestResult = productService.doShopping(productId, userId, requestNum, md5);
        ServerResponse<RequestResult> serverResponse = new ServerResponse<RequestResult>(requestResult, true, "success");
        return convertResponseToString(serverResponse);
    }

    @RequestMapping(value = "/currentTime", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getCurrentTime() {
        Date date = new Date();
        long curTime = date.getTime();
        ServerResponse<Long> serverResponse = new ServerResponse<Long>(curTime, true, "success");
        return convertResponseToString(serverResponse);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(@RequestBody LoginInfo loginInfo, HttpSession session) {
        try {
            String userName = loginInfo.getUserName();
            String password = loginInfo.getPassword();
            ResponseUser responseUser = userService.login(userName, password);
            boolean valid = responseUser.isLoginSuccess();
            if (valid) {
                session.setAttribute("userName", userName);
                ServerResponse<ResponseUser> serverResponse = new ServerResponse<ResponseUser>(responseUser, true, "success");
                return convertResponseToString(serverResponse);
            } else {
                ServerResponse<ResponseUser> serverResponse = new ServerResponse<ResponseUser>(false, "Please enter the correct password");
                return convertResponseToString(serverResponse);
            }
        } catch (NoSuchUserException e) {
            ServerResponse<ResponseUser> serverResponse = new ServerResponse<ResponseUser>(false, "No user match for user name: " + loginInfo.getUserName());
            return convertResponseToString(serverResponse);
        }
    }

    private String convertResponseToString(ServerResponse<?> serverResponse) {
        try {
            String jsonString = objectMapper.writeValueAsString(serverResponse);
            return jsonString;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "json convert error";
    }

}
