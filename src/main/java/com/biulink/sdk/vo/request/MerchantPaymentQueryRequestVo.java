package com.biulink.sdk.vo.request;

import com.biulink.sdk.enums.OrderTypeEnum;
import lombok.Data;

@Data
public class MerchantPaymentQueryRequestVo {
    /**
     * 商户订单号
     */
    private String tradeNo;

    /**
     * 系统订单号
     */
    private String orderNum;

    /**
     * 订单类型
     */
    private OrderTypeEnum orderType;
}