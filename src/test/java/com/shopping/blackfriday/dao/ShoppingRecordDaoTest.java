package com.shopping.blackfriday.dao;

import com.shopping.blackfriday.entity.ShoppingRecord;
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
public class ShoppingRecordDaoTest {

    @Resource
    ShoppingRecordDao shoppingRecordDao;

    @Test
    public void insertShoppingRecord() {
        int affected = shoppingRecordDao.insertShoppingRecord(1, 1, new Date(), 10);
        System.out.println(affected);
    }

    @Test
    public void queryShoppingRecordByUserId() {
        List<ShoppingRecord> list = shoppingRecordDao.queryShoppingRecordByUserId(1);
        assertNotNull(list);
        for(ShoppingRecord shoppingRecord:list){
            System.out.println(shoppingRecord.toString());
        }
    }

    @Test
    public void queryShoppingRecordByProductId() {
        List<ShoppingRecord> list = shoppingRecordDao.queryShoppingRecordByProductId(1);
        assertNotNull(list);
        for(ShoppingRecord shoppingRecord:list){
            System.out.println(shoppingRecord.toString());
        }
    }

    @Test
    public void queryShoppingRecordByUserAndProduct() {
        List<ShoppingRecord> list = shoppingRecordDao.queryShoppingRecordByUserAndProduct(1, 1);
        assertNotNull(list);
        for(ShoppingRecord shoppingRecord:list){
            System.out.println(shoppingRecord.toString());
        }
    }
}