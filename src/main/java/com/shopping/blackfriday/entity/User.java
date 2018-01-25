package com.shopping.blackfriday.entity;

import com.shopping.blackfriday.enums.PrivilegeEnum;

import java.util.Date;

public class User {
    private long userId;
    private String userName;
    private String password;
    private PrivilegeEnum privilege;
    private String email;
    private double balance;
    private Date createTime;
    private Date lastLoginTime;


    public User() {

    }

    public User(String userName, String password, PrivilegeEnum privilege, String email, double balance, Date createTime, Date lastLoginTime) {
        this.userName = userName;
        this.password = password;
        this.privilege = privilege;
        this.email = email;
        this.balance = balance;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PrivilegeEnum getPrivilege() {
        return privilege;
    }

    public void setPrivilege(PrivilegeEnum privilege) {
        this.privilege = privilege;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLogin() {
        return lastLoginTime;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLoginTime = lastLogin;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", privilege=" + privilege +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}



