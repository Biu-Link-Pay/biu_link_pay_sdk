package com.biulinkpay.sdk.vo.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class FiatPaymentMethodResponseVo {

    private String methodType;
    private List<FiatPaymentMethod> fiatPaymentMethod;

    @Data
    @Builder
    public static class FiatPaymentMethod {
        private String methodCode;
        private String methodName;
        private BigDecimal minLimit;
        private BigDecimal maxLimit;
        private BigDecimal fixedFee;
        private BigDecimal feeRatio;
        private String logoUrl;
        private String remark;
        private Integer expireTime;
        private String type;
        private List<PaymentFieldConfig> fields;
    }

    @Data
    public static class PaymentFieldConfig {
        private String name;
        private String label;
        private boolean required;
        private String type;
        private List<String> options;
        private String placeholder;
    }
}
