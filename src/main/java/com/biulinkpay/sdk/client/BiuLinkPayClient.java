package com.biulinkpay.sdk.client;

import com.biulinkpay.sdk.apiresponse.APIResponse;
import com.biulinkpay.sdk.common.BiuLinkPayRequestUtil;
import com.biulinkpay.sdk.url.PaymentUrl;
import com.biulinkpay.sdk.vo.BiuLinkPayConfig;
import com.biulinkpay.sdk.vo.request.*;
import com.biulinkpay.sdk.vo.response.*;
import com.google.gson.reflect.TypeToken;

import java.net.http.HttpClient;
import java.time.Duration;
import java.util.List;

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

    public BiuLinkPayOperation<String, List<FiatPaymentMethodResponseVo>> fiatPaymentMethod() {
        return requestData -> getRequest(PaymentUrl.paymentMethod + "?orderType=" + requestData, new TypeToken<List<FiatPaymentMethodResponseVo>>() {
        });
    }

    public BiuLinkPayOperation<String, MerchantPaymentMethodResponseVo> cryptoPaymentMethod() {
        return requestData -> getRequest(PaymentUrl.paymentMethod + "?orderType=" + requestData, new TypeToken<MerchantPaymentMethodResponseVo>() {
        });
    }

    public BiuLinkPayOperation<MerchantPaymentQueryRequestVo, MerchantPaymentQueryResponseVo> paymentQuery() {
        return requestData -> postRequest(PaymentUrl.queryUrl, requestData, new TypeToken<MerchantPaymentQueryResponseVo>() {
        });
    }

    public BiuLinkPayOperation<MerchantBuyRequestVo, ChannelInResponseVo> buyOrder() {
        return requestData -> postRequest(PaymentUrl.buyOrderUrl, requestData, new TypeToken<ChannelInResponseVo>() {
        });
    }

    public BiuLinkPayOperation<MerchantSellRequestVo, ChannelOutResponseVo> sellOrder() {
        return requestData -> postRequest(PaymentUrl.sellOrderUrl, requestData, new TypeToken<ChannelOutResponseVo>() {
        });
    }

    public BiuLinkPayOperation<RateRequestVo, RateQueryResponseVo> rateQuery() {
        return requestData -> postRequest(PaymentUrl.rateQueryUrl, requestData, new TypeToken<RateQueryResponseVo>() {
        });
    }

    public BiuLinkPayOperation<Void, List<BankInfoResponseVo>> bankQuery() {
        return requestData -> getRequest(PaymentUrl.bankInfoUrl, new TypeToken<List<BankInfoResponseVo>>() {
        });
    }

    public BiuLinkPayOperation<QueryRecipientRequestVo, RecipientInfoResponseVo> queryRecipient() {
        return requestData -> getRequest(PaymentUrl.queryRecipientUrl, requestData, new TypeToken<RecipientInfoResponseVo>() {
        });
    }

    public BiuLinkPayOperation<RecipientRequestVo, APIResponse> addRecipient() {
        return requestData -> postRequest(PaymentUrl.addRecipientUrl, requestData, new TypeToken<APIResponse>() {
        });
    }

    public BiuLinkPayOperation<Long, APIResponse> deleteRecipient() {
        return requestData -> getRequest(PaymentUrl.deleteRecipientUrl + "?contactId=" + requestData, new TypeToken<APIResponse>() {
        });
    }
}
