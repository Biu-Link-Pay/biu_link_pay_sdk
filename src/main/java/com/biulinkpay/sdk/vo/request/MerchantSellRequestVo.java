package com.biulinkpay.sdk.vo.request;

import com.biulinkpay.sdk.enums.CurrencyTypeEnum;
import com.biulinkpay.sdk.enums.DeductionMethodEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MerchantSellRequestVo {

    /**
     * 交易号
     */
    private String tradeNo;

    /**
     * 结算地址
     */
    private String settlementAddress;

    /**
     * 支付币种
     */
    private String orderToken;

    /**
     * 支付网络
     */
    private String orderNetwork;

    /**
     * 金额
     */
    private BigDecimal orderAmount;

    /**
     * 支付类型
     */
    private String payType;

    /**
     * 币种类型
     */
    private CurrencyTypeEnum currencyType;

    /**
     * memo备注
     */
    private String memo;

    /**
     * 法币单位
     */
    private String fiatUnit;

    /**
     * 手续费
     */
    private BigDecimal fee;

    /**
     * 手续费率
     */
    private BigDecimal feeRatio;

    /**
     * 支付完成回调地址
     */
    private String callbackUrl;

    /**
     * 扣款方式
     */
    private DeductionMethodEnum deductionMethod;

    /**
     * 支付参数
     */
    private String customParam;

    /**
     * 用户标记
     */
    private String userMark;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户编号
     */
    private String userNum;

    /**
     * 源法币单位
     */
    private String sourceFiatUnit;
}