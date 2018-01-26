package com.shopping.blackfriday.dao;

import com.shopping.blackfriday.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UserDao {
    User getUserById(@Param("userId") long userId);

    User getUserByUserName(@Param("userName") String userName);

    int checkUserById(@Param("userId") long userId);

    int checkUserByUserName(@Param("userName") String userName);

    int addNewUser(@Param("user") User user);

    int deleteUserById(@Param("userId") long userId);

    int updateUserInfo(@Param("user") User user);

    int increaseUserBalance(@Param("userId") long userId, @Param("amount") double amount);

    int updatePasswordById(@Param("userId") long userId, @Param("password") String password);

    int updateUserLastLoginById(@Param("userId") long userId, @Param("lastLogin") Date lastLoginTime);

}
