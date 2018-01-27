package com.shopping.blackfriday.web;

import com.shopping.blackfriday.dto.LoginInfo;
import com.shopping.blackfriday.dto.RequestResult;
import com.shopping.blackfriday.dto.ServerResponse;
import com.shopping.blackfriday.dto.ShoppingInfo;
import com.shopping.blackfriday.entity.Product;
import com.shopping.blackfriday.entity.User;
import com.shopping.blackfriday.enums.ServerResponseStateEnum;
import com.shopping.blackfriday.exception.NoSuchProductException;
import com.shopping.blackfriday.exception.NoSuchUserException;
import com.shopping.blackfriday.service.ProductService;
import com.shopping.blackfriday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
    public ShoppingInfo getShoppingInfo(@PathVariable("productId") Long productId) {
        ShoppingInfo shoppingInfo = productService.getShoppingInfo(productId);
        return shoppingInfo;
    }

    @RequestMapping(value = "/{productId}/{userId}/{num}/{md5}/request", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public RequestResult getRequestResult(@PathVariable("productId") Long productId, @PathVariable("userId") long userId, @PathVariable("num") int requestNum, @PathVariable("md5") String md5) {
        RequestResult requestResult = productService.doShopping(productId, userId, requestNum, md5);
        return requestResult;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ServerResponse<User> login(@RequestBody LoginInfo loginInfo) {
        try {
            String userName = loginInfo.getUserName();
            String password = loginInfo.getPassword();
            boolean valid = userService.validUser(userName, password);
            if (valid) {
                return new ServerResponse<User>(ServerResponseStateEnum.SUCCESS.getState(), "success");
            } else {
                return new ServerResponse<User>(ServerResponseStateEnum.Fail.getState(), "Wrong password");
            }
        } catch (NoSuchUserException e) {
            return new ServerResponse<User>(ServerResponseStateEnum.Fail.getState(), "No such user failure");
        }
    }

}
