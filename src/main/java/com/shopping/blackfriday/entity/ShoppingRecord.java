package com.shopping.blackfriday.entity;

import java.util.Date;

public class ShoppingRecord {
    private long userId;
    private long productId;
    private Date createTime;
    /*
        ShoppingRecord to Product is
        many to one relationship
     */
    private Product product;
    private int shoppingNumber;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "ShoppingRecord{" +
                "userId=" + userId +
                ", productId=" + productId +
                ", createTime=" + createTime +
                ", product=" + product +
                ", shoppingNumber=" + shoppingNumber +
                '}';
    }
}
