package com.shopping.blackfriday.service;

import com.shopping.blackfriday.dto.ResponseUser;
import com.shopping.blackfriday.entity.User;
import com.shopping.blackfriday.exception.NoSuchUserException;

import java.util.Date;

public interface UserService {
    User getUserById(long userId) throws NoSuchUserException;

    User getUserByUserName(String userName) throws NoSuchUserException;

    void addNewUser(User user);

    void deleteUserById(long userId);

    void updateUserInfo(User user);

    void increaseBalance(long userId, double amount);

    void decreaseBalance(long userId, double amount);

    void updatePasswordById(long userId, String password);

    void updateUserLastLoginById(long userId, Date date);

    void setLastLoginToCurTime(long userId);

    ResponseUser login(String userName, String password) throws NoSuchUserException;

}
