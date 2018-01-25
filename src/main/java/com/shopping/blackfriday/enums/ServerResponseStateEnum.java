package com.shopping.blackfriday.enums;

public enum ServerResponseStateEnum {
    SUCCESS(1, "success"),
    Fail(2, "fail");
    private int state;
    private String stateInfo;

    ServerResponseStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ServerResponseStateEnum stateOf(int index) {
        for (ServerResponseStateEnum serverResponseStateEnum : values()) {
            if (serverResponseStateEnum.state == index) {
                return serverResponseStateEnum;
            }
        }
        return null;
    }

}
