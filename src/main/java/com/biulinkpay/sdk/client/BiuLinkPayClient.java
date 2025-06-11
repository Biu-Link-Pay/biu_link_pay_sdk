package com.biulinkpay.sdk.client;

import com.biulinkpay.sdk.apiresponse.APIResponse;
import com.biulinkpay.sdk.common.BiuLinkPayRequestUtil;
import com.biulinkpay.sdk.url.PaymentUrl;
import com.biulinkpay.sdk.vo.BiuLinkPayConfig;
import com.biulinkpay.sdk.vo.request.*;
import com.biulinkpay.sdk.vo.response.ChannelInResponseVo;
import com.biulinkpay.sdk.vo.response.MerchantPaymentMethodResponseVo;
import com.biulinkpay.sdk.vo.response.MerchantPaymentQueryResponseVo;
import com.biulinkpay.sdk.vo.response.RateQueryResponseVo;

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

    public BiuLinkPayOperation<MerchantBuyRequestVo, APIResponse<ChannelInResponseVo>> buyOrder() {
        return requestData -> postRequest(PaymentUrl.buyOrderUrl, requestData, APIResponse.class);
    }

    public BiuLinkPayOperation<MerchantSellRequestVo, APIResponse<ChannelOutResponseVo>> sellOrder() {
        return requestData -> postRequest(PaymentUrl.sellOrderUrl, requestData, APIResponse.class);
    }

    public BiuLinkPayOperation<RateRequestVo, APIResponse<RateQueryResponseVo>> rateQuery() {
        return requestData -> postRequest(PaymentUrl.rateQueryUrl, requestData, APIResponse.class);
    }
}
