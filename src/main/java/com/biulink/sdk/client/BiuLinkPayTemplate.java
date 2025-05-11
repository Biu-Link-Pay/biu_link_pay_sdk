package com.biulink.sdk.client;

import com.biulink.sdk.common.BiuLinkPayException;
import com.biulink.sdk.common.BiuLinkPayHeaderUtil;
import com.biulink.sdk.common.GsonUtil;
import com.biulink.sdk.vo.BiuLinkPayConfig;
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
