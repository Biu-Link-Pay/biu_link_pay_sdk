/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */
package com.biulinkpay.sdk.apiresponse;

import java.util.ArrayList;
import java.util.List;

public enum CodeEnum {
    SUCCESS("0", "operator success"),
    ERROR("1", "operator error"),
    ;

    private final String code;
    private final String message;

    private CodeEnum(String _code, String _message) {
        this.code = _code;
        this.message = _message;
    }

    public static String getMessageByCode(String code) {
        for (CodeEnum _enum : values()) {
            if (_enum.getCode() == code) {
                return _enum.getMessage();
            }
        }
        return null;
    }

    public static CodeEnum getByCode(String code) {
        for (CodeEnum _enum : values()) {
            if (_enum.getCode() == code) {
                return _enum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<CodeEnum> getAllEnum() {
        List<CodeEnum> list = new ArrayList<CodeEnum>();
        for (CodeEnum _enum : values()) {
            list.add(_enum);
        }
        return list;
    }

    public List<String> getAllEnumCode() {
        List<String> list = new ArrayList<String>();
        for (CodeEnum _enum : values()) {
            list.add(_enum.getCode());
        }
        return list;
    }
}
