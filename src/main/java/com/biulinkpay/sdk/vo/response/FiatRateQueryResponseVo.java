package com.biulinkpay.sdk.vo.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class FiatRateQueryResponseVo {
    private Source source;

    private Target target;

    private FeeDetail feeDetail;

    @Data
    @Builder
    public static class Source{
        private String currency;
        private BigDecimal amount;
    }

    @Data
    @Builder
    public static class Target{
        private String currency;
        private BigDecimal rate;
        private BigDecimal amount;
    }

    @Data
    @Builder
    public static class FeeDetail{
        private BigDecimal feeRatio;
        private BigDecimal fixedFee;
        private BigDecimal amount;
        private String currency;
    }
}
