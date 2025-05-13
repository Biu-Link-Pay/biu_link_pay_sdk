package com.biulink.sdk.client;

import com.biulink.sdk.apiresponse.APIResponse;
import com.biulink.sdk.common.BiuLinkPayException;
import com.biulink.sdk.common.GsonUtil;
import com.biulink.sdk.vo.BiuLinkPayConfig;
import com.biulink.sdk.vo.request.MerchantPaymentRequestVo;
import com.biulink.sdk.vo.response.ChannelInResponseVo;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Tests {

    @Test
    public void aa() throws BiuLinkPayException {

        Gson gson = GsonUtil.gsonParse();

        BiuLinkPayClient biuLinkPayClient = new BiuLinkPayClient(
                BiuLinkPayConfig.builder().
                        appId("FEA21349995B45929AA26EC1AB6C1DA0").
                        secret("Eh1+2XmwSWZ8HJ8a98okMIux6GqWHZRPhe1vAwb8ziI=").
                        build()
        );

        /*APIResponse<MerchantPaymentMethodResponseVo> merchantPaymentMethodResponseVoAPIResponse= biuLinkPayClient.paymentMethod().execute("IN");
        System.out.println(gson.toJson(merchantPaymentMethodResponseVoAPIResponse.getModel()));*/

        /*MerchantPaymentQueryRequestVo merchantPaymentQueryRequestVo=new MerchantPaymentQueryRequestVo();
        //merchantPaymentQueryRequestVo.setOrderNum();
        merchantPaymentQueryRequestVo.setOrderType(OrderTypeEnum.OUT);
        merchantPaymentQueryRequestVo.setTradeNo("77889911117113676");
        APIResponse<MerchantPaymentQueryResponseVo> merchantPaymentQueryResponseVoAPIResponse=biuLinkPayClient.paymentQuery().execute(merchantPaymentQueryRequestVo);
        System.out.println(gson.toJson(merchantPaymentQueryResponseVoAPIResponse));*/

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("fiatUnit", "");
        jsonMap.put("cryptoUnit", "USDT");
        jsonMap.put("network", "BSC");
        jsonMap.put("number", 10000);
        jsonMap.put("saleDirection", "SELL");
        jsonMap.put("currencyType", "CRYPTO");
        jsonMap.put("exchange", "BINANCE");
        jsonMap.put("deductionMethod", "OUTER_BUCKLE");
        //jsonMap.put("fee", "0");
        jsonMap.put("feeRatio", "0.01");
        ;

        //APIResponse<RateQueryResponseVo> rateQueryResponseVoAPIResponse= biuLinkPayClient.rateQuery().execute(gson.fromJson(gson.toJson(jsonMap), RateRequestVo.class));
        //System.out.println(gson.toJson(rateQueryResponseVoAPIResponse));

        String json = "{\n" +
                "    \"tradeNo\": \"78889911117113676\",\n" +
                "    \"userMark\": \"123@123.com\",\n" +
                "    \"payType\": \"BINANCE\",\n" +
                "    \"orderAmount\": \"1\",\n" +
                "    \"orderToken\": \"USDT\",\n" +
                "    \"orderNetwork\": \"BSC\",\n" +
                "    \"expiredTime\": 100,\n" +
                "    \"settlementAddress\": \"150151157\",\n" +
                "    \"redirectUrl\": \"https://www.baidu.com\",\n" +
                "    \"callbackUrl\": \"https://biulink.online/api/pay/callback/gate\",\n" +
                "    \"refundCallbackUrl\": \"https://biulink.online/api/pay/callback/gate\",\n" +
                "    \"fiatUnit\": \"VND\",\n" +
                "    \"currencyType\": \"CRYPTO\",\n" +
                "    \"fee\": \"0.1\",\n" +
                "    \"feeRatio\": \"0.01\",\n" +
                "    \"deductionMethod\": OUTER_BUCKLE\n" +
                "}";
        APIResponse<ChannelInResponseVo> channelInResponseVoAPIResponse = biuLinkPayClient.createOrder().execute(gson.fromJson(json, MerchantPaymentRequestVo.class));
        System.out.println(gson.toJson(channelInResponseVoAPIResponse));
    }
}