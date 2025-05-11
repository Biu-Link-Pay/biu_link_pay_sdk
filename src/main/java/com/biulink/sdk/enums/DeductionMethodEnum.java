package com.biulink.sdk.enums;

public enum DeductionMethodEnum {
    /**
     * 内扣
     */
    INNER_BUCKLE("INNER_BUCKLE"),

    /**
     * 外扣
     */
    OUTER_BUCKLE("OUTER_BUCKLE"),

    ;

    private String value;

    private DeductionMethodEnum(String code) {
        this.value = code;
    }

    public String getValue() {
        return value;
    }
}