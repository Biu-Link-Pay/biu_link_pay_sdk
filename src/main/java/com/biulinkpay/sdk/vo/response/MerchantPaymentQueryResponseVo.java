package com.biulinkpay.sdk.vo.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MerchantPaymentQueryResponseVo {

    /**
     * 内部订单号
     */
    private String num;

    /**
     * 状态
     */
    private String status;

    /**
     * 商户订单号
     */
    private String tradeNo;

    /**
     * 退款商户订单号
     */
    private String refundTradeNo;

    /**
     * 用户标识
     */
    private String userMark;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单类型 入账，退款
     */
    private String orderType;

    /**
     * 退款类型
     */
    private String refundType;

    /**
     * 退款原因
     */
    private String refundReason;

    /**
     * 订单token
     */
    private String orderToken;

    /**
     * 订单网络
     */
    private String orderNetwork;

    /**
     * hashId
     */
    private String hashId;

    /**
     * 网络费
     */
    private BigDecimal networkFee;

    /**
     * 失败原因
     */
    private String failReason;
}
