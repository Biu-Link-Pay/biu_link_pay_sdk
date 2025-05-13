package com.biulinkpay.sdk.vo.request;

import com.biulinkpay.sdk.enums.CurrencyTypeEnum;
import com.biulinkpay.sdk.enums.DeductionMethodEnum;
import com.biulinkpay.sdk.enums.ExchangeEnum;
import com.biulinkpay.sdk.enums.SaleDirectionEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RateRequestVo {

    /**
     * 法币单位
     */
    private String fiatUnit;

    /**
     * 数币单位
     */
    private String cryptoUnit;

    /**
     * 网络
     */
    private String network;

    /**
     * 数量
     */
    private BigDecimal number;

    /**
     * 方向
     */
    private SaleDirectionEnum saleDirection;

    /**
     * 币种类型
     */
    private CurrencyTypeEnum currencyType;

    /**
     * 交易所
     */
    private ExchangeEnum exchange;

    /**
     * 手续费
     */
    private BigDecimal fee;

    /**
     * 手续费率
     */
    private BigDecimal feeRatio;

    /**
     * 内扣 or 外扣
     */
    private DeductionMethodEnum deductionMethod;
}
