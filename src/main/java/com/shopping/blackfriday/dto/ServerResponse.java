package com.shopping.blackfriday.dto;

import com.shopping.blackfriday.enums.ServerResponseStateEnum;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable {
    private T data;
    private boolean success;
    private String message;

    public ServerResponse(T data, boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }

    public ServerResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "data=" + data +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
