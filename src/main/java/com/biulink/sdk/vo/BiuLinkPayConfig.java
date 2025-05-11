package com.biulink.sdk.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BiuLinkPayConfig {

    private String appId;

    private String secret;

}
