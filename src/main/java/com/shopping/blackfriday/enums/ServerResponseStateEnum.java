package com.shopping.blackfriday.enums;

public enum ServerResponseStateEnum {
    SUCCESS(true, "success"),
    Fail(false, "fail");
    private boolean success;
    private String stateInfo;

    ServerResponseStateEnum(boolean success, String stateInfo) {
        this.success = success;
        this.stateInfo = stateInfo;
    }

    public boolean getState() {
        return success;
    }

    public String getStateInfo() {
        return stateInfo;
    }

}
