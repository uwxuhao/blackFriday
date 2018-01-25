package com.shopping.blackfriday.enums;

public enum PrivilegeEnum {
    Admin(0, "administrator"),
    Customer(1, "customer");
    private int privilege;
    private String privilegeInfo;

    PrivilegeEnum(int privilege, String privilegeInfo) {
        this.privilege = privilege;
        this.privilegeInfo = privilegeInfo;
    }

    public int getPrivilege() {
        return privilege;
    }

    public String getPrivilegeInfo() {
        return privilegeInfo;
    }
}
