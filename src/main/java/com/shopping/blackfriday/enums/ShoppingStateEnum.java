package com.shopping.blackfriday.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ShoppingStateEnum {
    SUCCESS(1, "SUCCESS"),
    END(2, "END"),
    NOT_ENOUGH(3, "NOT_ENOUGH"),
    WRONG_MD5(4, "WRONG_MD5"),
    INNER_ERROR(5, "INNER_ERROR");
    private int state;
    private String stateInfo;

    ShoppingStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ShoppingStateEnum stateOf(int index) {
        for (ShoppingStateEnum shoppingStateEnum : values()) {
            if (shoppingStateEnum.state == index) {
                return shoppingStateEnum;
            }
        }
        return null;
    }

}
