package com.biulinkpay.sdk.enums;

public enum TerminalTypeEnum {
    /**
     * 网页端
     */
    WEB("WEB"),

    /**
     * 小程序端
     */
    MINI_APP("MINI_APP"),

    ;

    private String value;

    private TerminalTypeEnum(String code) {
        this.value = code;
    }

    public String getValue() {
        return value;
    }

    public static TerminalTypeEnum getInstance(String value) {
        for (TerminalTypeEnum terminalTypeEnum : TerminalTypeEnum.values()) {
            if (terminalTypeEnum.getValue().equals(value)) {
                return terminalTypeEnum;
            }
        }
        return null;
    }
}
