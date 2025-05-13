package com.biulinkpay.sdk.enums;

public enum ExchangeEnum {

    /**
     * binance
     */
    BINANCE("BINANCE"),

    /**
     * gate
     */
    GATE("GATE"),

    ;

    private String value;

    private ExchangeEnum(String code) {
        this.value = code;
    }

    public String getValue() {
        return value;
    }

    public static ExchangeEnum getExchangeData(String value) {
        for (ExchangeEnum exchangeEnum : ExchangeEnum.values()) {
            if (exchangeEnum.getValue().equals(value)) {
                return exchangeEnum;
            }
        }
        return null;
    }
}
