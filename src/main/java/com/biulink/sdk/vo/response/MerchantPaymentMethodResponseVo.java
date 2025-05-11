package com.biulink.sdk.vo.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MerchantPaymentMethodResponseVo {

    private List<PayType> payTypes;

    @Data
    public static class PayType {
        private String name;
        private String img;
        private String detailsImg;
        private Integer sorts;
        private List<CryptoNetwork> cryptoNetworks;
    }

    @Data
    public static class CryptoNetwork {
        private BigDecimal minLimit;
        private BigDecimal maxLimit;
        private Integer sorts;
        private String type;
        private Crypto crypto;
        private Network network;
    }

    @Data
    public static class Crypto {
        private String name;
        private String fullName;
        private String logoUrl;
    }

    @Data
    public static class Network {
        private String name;
        private String addressRegex;
        private String fullName;
        private String sortName;
        private String logoUrl;
    }
}
