package com.shopping.blackfriday.enums;

public enum ShoppingStateEnum {
    SUCCESS(1, "success"),
    END(2, "end"),
    NOT_ENOUGH(3, "not enough inventory"),
    WRONG_MD5(4, "wrong md5"),
    INNER_ERROR(5, "inner error");
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
