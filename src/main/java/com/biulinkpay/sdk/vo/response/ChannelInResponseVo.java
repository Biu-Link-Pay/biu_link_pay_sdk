package com.biulinkpay.sdk.vo.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ChannelInResponseVo {
    private String webUrl;
    private String channelNum;

    private String orderNum;
    private String payCurrency;
    private String network;
    private BigDecimal payAmount;
    private Long expireTime;
    private String qrContent;
    private String qrcodeLink;
    private String deeplink;

    private AddressInfo address;

    @Data
    @Builder
    public static class AddressInfo {
        private String address;
        private String chainType;
        private String fullCurrType;
    }
}
