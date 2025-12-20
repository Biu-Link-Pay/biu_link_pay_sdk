package com.biulinkpay.sdk.vo.request;

import com.biulinkpay.sdk.enums.DeductionMethodEnum;
import com.biulinkpay.sdk.enums.SaleDirectionEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FiatRateRequestVo {

    /**
     * 数量
     */
    private BigDecimal number;

    /**
     * 方向
     */
    private SaleDirectionEnum saleDirection;

    /**
     * 法币单位
     */
    private String source;

    /**
     * 目标法币单位
     */
    private String target;

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
