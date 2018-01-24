package com.shopping.blackfriday.service;

import com.shopping.blackfriday.dto.RequestResult;
import com.shopping.blackfriday.dto.ShoppingInfo;
import com.shopping.blackfriday.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void getProductById() {
        Product product = productService.getProductById(3);
        System.out.println(product);
    }

    @Test
    public void getAllProducts() {
        List<Product> list = productService.getAllProducts();
        System.out.println(list);
    }

    @Test
    public void getShoppingInfo() {
        ShoppingInfo shoppingInfo = productService.getShoppingInfo(100);
        System.out.println(shoppingInfo);
    }

    @Test
    public void doShopping() {
        long productId=100;
        ShoppingInfo shoppingInfo = productService.getShoppingInfo(productId);
        RequestResult requestResult = productService.doShopping(productId, 1, 90, shoppingInfo.getMd5());
        System.out.println(requestResult);
    }
}