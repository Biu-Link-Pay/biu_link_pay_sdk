package com.biulinkpay.sdk.vo.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BankInfoResponseVo {
    private List<String> bankName;
    private String countryCode;
}
