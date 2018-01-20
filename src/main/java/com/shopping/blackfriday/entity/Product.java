package com.shopping.blackfriday.entity;

import java.util.Date;

public class Product {
    private long id;
    private String name;
    private Date startTime;
    private Date endTime;
    private int inventory;

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", inventory=" + inventory +
                '}';
    }
}
