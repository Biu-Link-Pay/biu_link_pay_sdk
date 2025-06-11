package com.biulinkpay.sdk.vo.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChannelOutResponseVo {
    private String tradeNo;
    private boolean invoke;
    private String message;
}
