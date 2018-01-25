package com.shopping.blackfriday.dao;

import com.shopping.blackfriday.entity.User;
import com.shopping.blackfriday.enums.PrivilegeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// Load the spring-dao.xml file to configure spring
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {


    @Resource
    UserDao userDao;

    @Test
    public void getUserById() {
        User user = userDao.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void getUserByUserName() {
        User user = userDao.getUserByUserName("customer");
        System.out.println(user);
    }

    @Test
    public void addNewUser() {
        User user = new User("hao", "default", PrivilegeEnum.Customer, "xuhao@uw.edu", 100, new Date(), new Date());
        userDao.addNewUser(user);
        User anotherUser = userDao.getUserByUserName("hao");
        System.out.println(anotherUser);

    }

    @Test
    public void deleteUserById() {
        userDao.deleteUserById(3);
        User user = userDao.getUserById(3);
        System.out.println(user);
    }

    @Test
    public void updateUserInfo() {
        User user = new User();
        user.setUserId(1);
        user.setEmail("root@sjtu.edu.cn");
        userDao.updateUserInfo(user);
        user = userDao.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void changeUserBalance() {
        userDao.changeUserBalance(1, 20000);
        User user = userDao.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void updatePasswordById() {
        userDao.updatePasswordById(1, "helloworld");
        User user = userDao.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void updateUserLastLoginById() {
        userDao.updateUserLastLoginById(1, new Date());
        User user = userDao.getUserById(1);
        System.out.println(user);
    }
}