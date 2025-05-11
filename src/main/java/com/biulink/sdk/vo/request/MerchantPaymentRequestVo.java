package com.biulink.sdk.vo.request;

import com.biulink.sdk.enums.CurrencyTypeEnum;
import com.biulink.sdk.enums.DeductionMethodEnum;
import com.biulink.sdk.enums.ExchangeEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MerchantPaymentRequestVo {

    /**
     * 交易号
     */
    private String tradeNo;

    /**
     * 用户标记
     */
    private String userMark;

    /**
     * 支付类型
     */
    private ExchangeEnum payType;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 支付币种
     */
    private String orderToken;

    /**
     * 支付网络
     */
    private String orderNetwork;

    /**
     * 结算地址
     */
    private String settlementAddress;

    /**
     * 币种类型
     */
    private CurrencyTypeEnum currencyType;

    /**
     * 法币单位
     */
    private String fiatUnit;

    /**
     * 超时时间
     */
    private BigDecimal expiredTime;

    /**
     * 支付成功重定向地址
     */
    private String redirectUrl;

    /**
     * 支付完成回调地址
     */
    private String callbackUrl;

    /**
     * 退款回调地址
     */
    private String refundCallbackUrl;

    /**
     * 手续费
     */
    private BigDecimal fee;

    /**
     * 手续费率
     */
    private BigDecimal feeRatio;

    /**
     * 扣款方式
     */
    private DeductionMethodEnum deductionMethod;
}
