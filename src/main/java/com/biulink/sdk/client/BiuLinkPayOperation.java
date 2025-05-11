package com.biulink.sdk.client;

import com.biulink.sdk.common.BiuLinkPayException;

@FunctionalInterface
public interface BiuLinkPayOperation<S, T> {
    T execute(S t) throws BiuLinkPayException;
}
