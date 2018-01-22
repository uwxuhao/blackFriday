package com.shopping.blackfriday.dao;

import com.shopping.blackfriday.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// Load the spring-dao.xml file to configure spring
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ProductDaoTest {

    @Resource
    ProductDao productDao;

    @Test
    public void modifyInventoryNumber() {
        int affectNumber = productDao.modifyInventoryNumber(1, new Date(), 10);
        System.out.println(affectNumber);


    }

    @Test
    public void queryProductById() {
        Product product = productDao.queryProductById(1);
        assertNotNull(product);
        System.out.println(product);
    }

    @Test
    public void queryAllProduct() {
        List<Product> list = productDao.queryAllProducts();
        assertNotNull(list);
        System.out.println(list);
    }
}