package com.shopping.blackfriday.dto;

import java.util.Date;


public class ShoppingInfo {
    private boolean isOpened;
    private String md5;
    private long productId;
    private Date curTime;
    private Date startTime;
    private Date endTime;

    public ShoppingInfo(boolean isOpened, String md5, long productId, Date curTime, Date startTime, Date endTime) {
        this.isOpened = isOpened;
        this.md5 = md5;
        this.productId = productId;
        this.curTime = curTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Date getCurTime() {
        return curTime;
    }

    public void setCurTime(Date curTime) {
        this.curTime = curTime;
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
        return "ShoppingInfo{" +
                "isOpened=" + isOpened +
                ", md5='" + md5 + '\'' +
                ", productId=" + productId +
                ", curTime=" + curTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
