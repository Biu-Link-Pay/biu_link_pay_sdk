package com.biulinkpay.sdk.common;

import com.biulinkpay.sdk.url.PaymentUrl;
import com.biulinkpay.sdk.vo.BiuLinkPayConfig;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.function.Function;

public class BiuLinkPayRequestUtil {

    private final Gson gson = GsonUtil.gsonParse();

    private final HttpClient httpClient;

    private final BiuLinkPayConfig biuLinkPayConfig;

    public BiuLinkPayRequestUtil(HttpClient httpClient, BiuLinkPayConfig biuLinkPayConfig) {
        this.httpClient = httpClient;
        this.biuLinkPayConfig = biuLinkPayConfig;
    }

    protected <S, T> T postRequest(String endpoint, S data, Class<T> responseType) throws BiuLinkPayException {
        return handleRequest(
                endpoint,
                data,
                response -> gson.fromJson(response, responseType),
                "POST"
        );
    }

    protected <T> T getRequest(String endpoint, Class<T> responseType) throws BiuLinkPayException {
        return handleRequest(
                endpoint,
                null,
                response -> gson.fromJson(response, responseType),
                "GET"
        );
    }

    private <S, T> T handleRequest(String endpoint, S t, Function<String, T> responseProcessor, String method) throws BiuLinkPayException {
        try {

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(PaymentUrl.domain + endpoint))
                    .headers(BiuLinkPayHeaderUtil.getHeaderArray(biuLinkPayConfig, null != t ? gson.toJson(t) : ""))
                    .timeout(Duration.ofSeconds(10))
                    .method(method, method.equals("POST") ? HttpRequest.BodyPublishers.ofString(gson.toJson(t)) : HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                return responseProcessor.apply(response.body());
            }

            throw new BiuLinkPayException(
                    "BiuLinkPay API request failed: " + response.body(),
                    response.statusCode()
            );
        } catch (Exception e) {
            throw new BiuLinkPayException("BiuLinkPay API request failed", e);
        }
    }
}
