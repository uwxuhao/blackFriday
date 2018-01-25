package com.shopping.blackfriday.dto;

import com.shopping.blackfriday.enums.ServerResponseStateEnum;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable {
    private T data;
    private ServerResponseStateEnum state;
    private String message;
}
