package com.shopping.blackfriday.entity;

import java.util.Date;

public class ShoppingRecord {
    private long id;
    private String userId;
    private String productName;
    private Date createTime;

    /*
        ShoppingRecord to Product is
        many to one relationship
     */
    private Product product;
    private int shoppingNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getShoppingNumber() {
        return shoppingNumber;
    }

    public void setShoppingNumber(int shoppingNumber) {
        this.shoppingNumber = shoppingNumber;
    }
}
