package com.shopping.blackfriday.dto;


public class RequestResult {
    private String state;

    public RequestResult(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RequestResult{" +
                "state=" + state +
                '}';
    }
}
