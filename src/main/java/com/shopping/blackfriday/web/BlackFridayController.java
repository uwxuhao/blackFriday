package com.shopping.blackfriday.web;

import com.shopping.blackfriday.dto.RequestResult;
import com.shopping.blackfriday.dto.ShoppingInfo;
import com.shopping.blackfriday.entity.Product;
import com.shopping.blackfriday.exception.NoSuchProductException;
import com.shopping.blackfriday.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/blackFriday")
public class BlackFridayController {
    @Autowired
    private ProductService productService;

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

    @RequestMapping(value = "/{productId}/{num}/{md5}/request", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public RequestResult getRequestResult(@PathVariable("productId") Long productId, @PathVariable("num") int requestNum, @PathVariable("md5") String md5) {
        RequestResult requestResult = productService.doShopping(productId, 5120309232L, requestNum, md5);
        return requestResult;
    }

}
