package com.biulink.sdk.enums;

public enum SaleDirectionEnum {

    /**
     * 买
     */
    BUY("BUY"),

    /**
     * 卖
     */
    SELL("SELL"),

    ;

    private String value;

    private SaleDirectionEnum(String code) {
        this.value = code;
    }

    public String gatValue() {
        return value;
    }
}
