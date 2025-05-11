package com.biulink.sdk.enums;

public enum CurrencyTypeEnum {
    /**
     * 法币
     */
    FIAT("FIAT"),

    /**
     * 数币
     */
    CRYPTO("CRYPTO"),

    ;

    private String value;

    private CurrencyTypeEnum(String code) {
        this.value = code;
    }

    public String getValue() {
        return value;
    }

    public static CurrencyTypeEnum getEnumByValue(String value) {
        for (CurrencyTypeEnum e : CurrencyTypeEnum.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        return null;
    }
}
