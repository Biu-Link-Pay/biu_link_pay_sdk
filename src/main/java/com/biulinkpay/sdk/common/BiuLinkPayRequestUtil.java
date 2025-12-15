package com.biulinkpay.sdk.common;

import com.biulinkpay.sdk.apiresponse.APIResponse;
import com.biulinkpay.sdk.url.PaymentUrl;
import com.biulinkpay.sdk.vo.BiuLinkPayConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BiuLinkPayRequestUtil {

    private final Gson gson = GsonUtil.gsonParse();

    private final HttpClient httpClient;

    private final BiuLinkPayConfig biuLinkPayConfig;

    public BiuLinkPayRequestUtil(HttpClient httpClient, BiuLinkPayConfig biuLinkPayConfig) {
        this.httpClient = httpClient;
        this.biuLinkPayConfig = biuLinkPayConfig;
    }

    protected <S, T> T postRequest(String endpoint, S data, TypeToken<T> typeToken) throws BiuLinkPayException {
        return handleRequest(
                endpoint,
                data,
                response -> gson.fromJson(response, apiResponseMapping(typeToken.getType())),
                "POST"
        );
    }

    protected <T> T getRequest(String endpoint, TypeToken<T> typeToken) throws BiuLinkPayException {
        return handleRequest(
                endpoint,
                null,
                response -> gson.fromJson(response, apiResponseMapping(typeToken.getType())),
                "GET"
        );
    }

    protected <S, T> T getRequest(String endpoint, S data, TypeToken<T> typeToken) throws BiuLinkPayException {
        return handleRequest(
                endpoint + "?" + getParams(data),
                null,
                response -> gson.fromJson(response, apiResponseMapping(typeToken.getType())),
                "GET"
        );
    }

    private Type apiResponseMapping(Type typeToken) {
        return TypeToken.getParameterized(APIResponse.class, typeToken).getType();
    }

    private static <S> String getParams(S data) {
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(gson.toJson(data), Map.class);

        return map.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue().toString(), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));
    }

    private <S, T> T handleRequest(String endpoint, S t, Function<String, APIResponse<T>> responseProcessor, String method) throws BiuLinkPayException {
        try {

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(PaymentUrl.domain + endpoint))
                    .headers(BiuLinkPayHeaderUtil.getHeaderArray(biuLinkPayConfig, null != t ? gson.toJson(t) : ""))
                    .timeout(Duration.ofSeconds(10))
                    .method(method, method.equals("POST") ? HttpRequest.BodyPublishers.ofString(gson.toJson(t)) : HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                APIResponse<T> apiResponse = responseProcessor.apply(response.body());
                if (apiResponse.isError()) {
                    throw new BiuLinkPayException(apiResponse.getMsg());
                }
                return apiResponse.getModel();
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
