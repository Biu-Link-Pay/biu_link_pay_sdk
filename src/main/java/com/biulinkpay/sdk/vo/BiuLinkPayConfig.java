package com.biulinkpay.sdk.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class BiuLinkPayConfig {

    @NonNull
    private String appId;

    @NonNull
    private String secret;

    @NonNull
    private String merchantType;
}
