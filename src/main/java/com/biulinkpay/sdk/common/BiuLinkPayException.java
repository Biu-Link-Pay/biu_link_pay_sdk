package com.biulinkpay.sdk.common;

public class BiuLinkPayException extends Exception{
    private final int statusCode;

    public BiuLinkPayException(String message) {
        this(message, -1);
    }

    public BiuLinkPayException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public BiuLinkPayException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = -1;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
