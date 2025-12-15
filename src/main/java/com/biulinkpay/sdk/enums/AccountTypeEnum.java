package com.biulinkpay.sdk.enums;

public enum AccountTypeEnum {
    INDIVIDUAL("INDIVIDUAL"),

    ENTERPRISE("ENTERPRISE");

    String value;

    private AccountTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
