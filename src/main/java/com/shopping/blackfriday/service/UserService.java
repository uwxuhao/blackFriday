package com.shopping.blackfriday.service;

import com.shopping.blackfriday.entity.User;

import java.util.Date;

public interface UserService {
    User getUserById(long userId);

    User getUserByUserName(String userName);

    void addNewUser(User user);

    void deleteUserById(long userId);

    void updateUserInfo(User user);

    void increaseBalance(long userId, double amount);

    void decreaseBalance(long userId, double amount);

    void updatePasswordById(long userId, String password);

    void updateUserLastLoginById(long userId, Date date);

    boolean validUser(String userName, String password);

}
