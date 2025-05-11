package com.biulink.sdk.common;

import com.biulink.sdk.vo.BiuLinkPayConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import static com.biulink.sdk.sign.SHA512Sign.signature;

public class BiuLinkPayHeaderUtil {

    public static String[] getHeaderArray(BiuLinkPayConfig biuLinkPayConfig, String requestJsonData) {
        return headers(biuLinkPayConfig, requestJsonData).entrySet().stream()
                .flatMap(entry -> Stream.of(entry.getKey(), entry.getValue()))
                .toArray(String[]::new);
    }

    public static Map<String, String> getHeaderMap(BiuLinkPayConfig biuLinkPayConfig, String requestJsonData) {
        return headers(biuLinkPayConfig, requestJsonData);
    }

    private static Map<String, String> headers(BiuLinkPayConfig biuLinkPayConfig, String requestJsonData) {
        try {

            requestJsonData = requestJsonData.trim().startsWith("{") && requestJsonData.trim().endsWith("}") ? requestJsonData : "";

            Map<String, String> headers = new HashMap<String, String>();
            String nonce = UUID.randomUUID().toString().replace("-", "");
            String currentTime = String.valueOf(System.currentTimeMillis());
            String payload = String.format("%s\n%s\n%s\n", currentTime, nonce, requestJsonData);

            headers.put("Content-Type", "application/json");
            headers.put("BiuLinkPay-AppId", biuLinkPayConfig.getAppId());
            headers.put("BiuLinkPay-TimeStamp", currentTime);
            headers.put("BiuLinkPay-Nonce", nonce);
            headers.put("BiuLinkPay-Signature", signature(biuLinkPayConfig.getSecret(), payload));
            return headers;
        } catch (Exception exception) {
            throw new RuntimeException(
                    String.format("header params is error: %s", exception.getMessage()),
                    exception
            );
        }
    }
}
