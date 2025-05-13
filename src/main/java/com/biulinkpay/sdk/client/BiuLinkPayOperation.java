package com.biulinkpay.sdk.client;

import com.biulinkpay.sdk.common.BiuLinkPayException;

@FunctionalInterface
public interface BiuLinkPayOperation<S, T> {
    T execute(S t) throws BiuLinkPayException;
}
