package com.biulinkpay.sdk.client;

import com.biulinkpay.sdk.common.BiuLinkPayException;
import com.biulinkpay.sdk.common.BiuLinkPayHeaderUtil;
import com.biulinkpay.sdk.common.GsonUtil;
import com.biulinkpay.sdk.vo.BiuLinkPayConfig;
import com.google.gson.Gson;

public abstract class BiuLinkPayTemplate<S, T> {

    public final Gson gson = GsonUtil.gsonParse();

    public T handle(BiuLinkPayConfig biuLinkPayConfig, S s) throws BiuLinkPayException {
        try {

            String requestJsonData = gson.toJson(s);

            String[] headers = BiuLinkPayHeaderUtil.getHeaderArray(biuLinkPayConfig, requestJsonData);

            return requestSend(headers, s);
        } catch (Exception exception) {
            throw new BiuLinkPayException("BiuLinkPay API request failed", exception);
        }
    }

    public abstract T requestSend(Object headers, S requestJsonData);


}
