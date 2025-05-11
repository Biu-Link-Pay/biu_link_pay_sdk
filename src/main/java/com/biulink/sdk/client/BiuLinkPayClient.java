package com.biulink.sdk.client;

import com.biulink.sdk.apiresponse.APIResponse;
import com.biulink.sdk.common.BiuLinkPayRequestUtil;
import com.biulink.sdk.url.PaymentUrl;
import com.biulink.sdk.vo.BiuLinkPayConfig;
import com.biulink.sdk.vo.request.MerchantPaymentQueryRequestVo;
import com.biulink.sdk.vo.request.MerchantPaymentRequestVo;
import com.biulink.sdk.vo.request.RateRequestVo;
import com.biulink.sdk.vo.response.ChannelInResponseVo;
import com.biulink.sdk.vo.response.MerchantPaymentMethodResponseVo;
import com.biulink.sdk.vo.response.MerchantPaymentQueryResponseVo;
import com.biulink.sdk.vo.response.RateQueryResponseVo;

import java.net.http.HttpClient;
import java.time.Duration;

public class BiuLinkPayClient extends BiuLinkPayRequestUtil {

    public BiuLinkPayClient(BiuLinkPayConfig biuLinkPayConfig) {
        super(
                HttpClient.newBuilder()
                        .connectTimeout(Duration.ofSeconds(10))
                        .build(),
                biuLinkPayConfig
        );
    }

    public BiuLinkPayClient(HttpClient httpClient, BiuLinkPayConfig biuLinkPayConfig) {
        super(
                httpClient,
                biuLinkPayConfig
        );
    }

    public BiuLinkPayOperation<String, APIResponse<MerchantPaymentMethodResponseVo>> paymentMethod() {
        return requestData -> getRequest(PaymentUrl.paymentMethod + "?orderType=" + requestData, APIResponse.class);
    }

    public BiuLinkPayOperation<MerchantPaymentQueryRequestVo, APIResponse<MerchantPaymentQueryResponseVo>> paymentQuery() {
        return requestData -> postRequest(PaymentUrl.queryUrl, requestData, APIResponse.class);
    }

    public BiuLinkPayOperation<MerchantPaymentRequestVo, APIResponse<ChannelInResponseVo>> createOrder() {
        return requestData -> postRequest(PaymentUrl.insertUrl, requestData, APIResponse.class);
    }

    public BiuLinkPayOperation<RateRequestVo, APIResponse<RateQueryResponseVo>> rateQuery() {
        return requestData -> postRequest(PaymentUrl.rateQueryUrl, requestData, APIResponse.class);
    }
}
