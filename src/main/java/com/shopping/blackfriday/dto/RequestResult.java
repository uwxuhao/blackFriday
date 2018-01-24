package com.shopping.blackfriday.dto;

import com.shopping.blackfriday.enums.ShoppingStateEnum;

import java.util.Date;

public class RequestResult {
    private ShoppingStateEnum state;

    public RequestResult(ShoppingStateEnum state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RequestResult{" +
                "state=" + state +
                '}';
    }
}
