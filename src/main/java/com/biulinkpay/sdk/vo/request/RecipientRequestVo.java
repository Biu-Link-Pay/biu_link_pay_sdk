package com.biulinkpay.sdk.vo.request;

import com.biulinkpay.sdk.enums.AccountTypeEnum;
import lombok.Data;

@Data
public class RecipientRequestVo {

    private AccountTypeEnum accountType;

    private String bankLocation;

    private String bankName;

    private String currency;

    private String reservedPhoneNumber;

    private String firstName;

    private String lastName;

    private String recipientLocation;

    private String recipientProvince;

    private String recipientCity;

    private String recipientAddress;

    private String bankAccountNumber;

    private String swiftCode;

    private String email;

    private String userNum;
}
