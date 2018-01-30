package com.shopping.blackfriday.dto;

import java.io.Serializable;
import java.util.Date;

public class ResponseUser implements Serializable {
    private boolean loginSuccess;
    private long userId;
    private String userName;
    private String email;
    private double balance;


    public ResponseUser(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public ResponseUser(boolean loginSuccess, long userId, String userName, String email, double balance) {
        this.loginSuccess = loginSuccess;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.balance = balance;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
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

    @Override
    public String toString() {
        return "ResponseUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }
}
