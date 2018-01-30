package com.shopping.blackfriday.service;

import com.shopping.blackfriday.entity.User;
import com.shopping.blackfriday.enums.PrivilegeEnum;
import com.shopping.blackfriday.exception.NoSuchUserException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void getUserById() {
        User user = userService.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void getUserByUserName() {
        User user = userService.getUserByUserName("root");
        System.out.println(user);
    }

    @Test
    public void addNewUser() {
        User newUser = new User("admin", "default", PrivilegeEnum.Admin, "admin@uw.edu", 0, new Date(), new Date());
        userService.addNewUser(newUser);
    }

    @Test
    public void deleteUserById() {
        userService.deleteUserById(1);
        try{
            User user = userService.getUserById(1);
        } catch (NoSuchUserException e){
            return;
        }
        throw new RuntimeException();
    }

    @Test
    public void updateUserInfo() {
        User updateUser = new User();
        updateUser.setUserId(4);
        updateUser.setUserName("admin");
        updateUser.setEmail("admin@ad.com");
        userService.updateUserInfo(updateUser);
    }

    @Test
    public void increaseBalance() {
        userService.increaseBalance(4, 1000);
    }

    @Test
    public void decreaseBalance() {
        userService.decreaseBalance(4, 500);
    }

    @Test
    public void updatePasswordById() {
        userService.updatePasswordById(4, "admin");
    }

    @Test
    public void updateUserLastLoginById() {
        userService.updateUserLastLoginById(4, new Date());
    }


}