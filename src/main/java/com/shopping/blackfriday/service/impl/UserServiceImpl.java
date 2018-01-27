package com.shopping.blackfriday.service.impl;

import com.shopping.blackfriday.common.Constant;
import com.shopping.blackfriday.dao.UserDao;
import com.shopping.blackfriday.entity.User;
import com.shopping.blackfriday.exception.NoSuchUserException;
import com.shopping.blackfriday.exception.UserIdAlreadyExistException;
import com.shopping.blackfriday.exception.UserIdNameNotMatchException;
import com.shopping.blackfriday.exception.UserNameAlreadyExistException;
import com.shopping.blackfriday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(long userId) throws NoSuchUserException {
        User user = userDao.getUserById(userId);
        if (user == null) throw new NoSuchUserException("The user id: " + userId + " dose not exist in data base ");
        return user;
    }

    public User getUserByUserName(String userName) {
        User user = userDao.getUserByUserName(userName);
        if (user == null) throw new NoSuchUserException("The user name: " + userName + " dose not exist in data base ");
        return user;
    }

    public void addNewUser(User user) {
        long userId = user.getUserId();
        String userName = user.getUserName();
        int count = userDao.checkUserById(userId);
        if (count > 0) {
            throw new UserIdAlreadyExistException("The id " + userId + " already exist in data base");
        }
        count = userDao.checkUserByUserName(userName);
        if (count > 0) {
            throw new UserNameAlreadyExistException("The name " + userName + " already exist in data base");
        }
        user.setPassword(getMD5(user.getUserId(), user.getPassword()));
        userDao.addNewUser(user);
    }

    public void deleteUserById(long userId) {
        int count = userDao.checkUserById(userId);
        if (count <= 0) {
            throw new NoSuchUserException("The user id: " + userId + " dose not exist in data base");
        }
        userDao.deleteUserById(userId);
    }

    public void updateUserInfo(User user) {
        long userId = user.getUserId();
        User oldUser = userDao.getUserById(userId);
        if (!oldUser.getUserName().equals(user.getUserName())) {
            throw new UserIdNameNotMatchException("expected user name for id " + userId + " is " + oldUser.getUserName() + ", but actually " + user.getUserName());
        }
        userDao.updateUserInfo(user);
    }

    public void increaseBalance(long userId, double amount) {
        int count = userDao.checkUserById(userId);
        if (count <= 0) {
            throw new NoSuchUserException("The user id: " + userId + " dose not exist in data base");
        }
        userDao.increaseUserBalance(userId, amount);
    }

    public void decreaseBalance(long userId, double amount) {
        increaseBalance(userId, -amount);
    }

    public void updatePasswordById(long userId, String password) {
        int count = userDao.checkUserById(userId);
        if (count <= 0) {
            throw new NoSuchUserException("The user id: " + userId + " dose not exist in data base");
        }
        String md5Password = getMD5(userId, password);
        userDao.updatePasswordById(userId, md5Password);
    }

    public void updateUserLastLoginById(long userId, Date date) {
        int count = userDao.checkUserById(userId);
        if (count <= 0) {
            throw new NoSuchUserException("The user id: " + userId + " dose not exist in data base");
        }
        userDao.updateUserLastLoginById(userId, date);
    }

    public boolean validUser(String userName, String password) {
        User user = getUserByUserName(userName);
        String md5Password = getMD5(user.getUserId(), password);
        if (md5Password.equals(user.getPassword())) return true;
        else return false;
    }

    private String getMD5(long userId, String password) {
        String base = userId + "/" + password + "/" + Constant.SALT_PASSWORD;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    public void login(long userId) {
        updateUserLastLoginById(userId, new Date());
    }

}
