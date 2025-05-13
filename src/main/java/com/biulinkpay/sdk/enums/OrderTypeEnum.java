package com.biulinkpay.sdk.enums;

public enum OrderTypeEnum {
    /**
     * 入金
     */
    IN("IN"),

    /**
     * 出金
     */
    OUT("OUT"),

    ;

    private String value;

    private OrderTypeEnum(String code) {
        this.value = code;
    }

    public String getValue() {
        return value;
    }

    public static OrderTypeEnum getOrderTypeValue(String value) {
        for (OrderTypeEnum e : OrderTypeEnum.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        return null;
    }
}
