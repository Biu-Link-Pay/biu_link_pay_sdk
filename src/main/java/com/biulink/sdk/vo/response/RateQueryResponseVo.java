package com.biulink.sdk.vo.response;

import com.biulink.sdk.enums.CurrencyTypeEnum;
import com.biulink.sdk.enums.SaleDirectionEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RateQueryResponseVo {

    /**
     * 币种类型
     */
    private CurrencyTypeEnum currencyType;

    /**
     * 方向
     */
    private SaleDirectionEnum saleDirection;

    /**
     * usdT手续费
     */
    private String usdTFee;

    /**
     * 数量
     */
    private String number;

    /**
     * usdT总金额
     */
    private String totalAmountUsdT;

    /**
     * 法币明细
     */
    private FiatDetail fiatDetail;

    /**
     * 数币明细
     */
    private CryptoDetail cryptoDetail;

    /**
     * 法币明细
     */
    @Data
    @Builder
    public static class FiatDetail {
        /**
         * 法币单位
         */
        private String fiatUnit;

        /**
         * 法币手续费
         */
        private String fiatFee;

        /**
         * 法币金额
         */
        private String fiatAmount;

        /**
         * 法币转U汇率
         */
        private String fiatToUsdRate;

        /**
         * 法币总金额
         */
        private String totalAmountFiat;
    }

    /**
     * 数币明细
     */
    @Data
    @Builder
    public static class CryptoDetail {
        /**
         * 数币单位
         */
        private String cryptoUnit;

        /**
         * 数币手续费
         */
        private String cryptoFee;

        /**
         * 数币金额
         */
        private String cryptoAmount;

        /**
         * 数币转U汇率
         */
        private String cryptoToUsdTRate;

        /**
         * 数币总金额
         */
        private String totalAmountCrypto;
    }
}
