package com.biulinkpay.sdk.apiresponse;


import java.io.Serializable;

public class APIResponse<T> implements Serializable {

    private String code = CodeEnum.SUCCESS.getCode();

    private String msg = CodeEnum.SUCCESS.getMessage();

    private T model;

    private String traceId;

    private boolean success;

    private boolean error;

    public APIResponse(String code, String message, T t) {
        this.code = code;
        this.msg = message;
        this.model = t;
        this.success = isSuccess();
        this.error = isError();
    }


    /**
     * 是否异常
     *
     * @return
     */
    //@JSONField(serialize = false)
    public boolean isError() {
        if (!this.getCode().equals(CodeEnum.SUCCESS.getCode())) {
            return true;
        }
        return false;
    }

    /**
     * 是否正确
     *
     * @return
     */
    //@JSONField(serialize = false)
    public boolean isSuccess() {
        if (this.getCode().equals(CodeEnum.SUCCESS.getCode())) {
            return true;
        }
        return false;
    }

    /**
     * 返回成功，返回类型为服务器类型
     */
    public static <T> APIResponse<T> success(T t) {
        return new APIResponse(CodeEnum.SUCCESS.getCode(), "SUCCESS", t);
    }

    /**
     * 返回成功，返回类型为服务器类型
     */
    public static <T> APIResponse<T> success(T t, String code) {
        return new APIResponse(code, "SUCCESS", t);
    }

    /**
     * 返回成功，返回类型为服务器类型
     */
    public static <T> APIResponse<T> success() {
        return new APIResponse(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 返回失败，自定义
     */
    public static <T> APIResponse<T> error(String code, String message, T t) {
        return new APIResponse(code, message, t);
    }

    /**
     * 返回失败，自定义
     */
    public static <T> APIResponse<T> error() {
        return new APIResponse(CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getMessage(), null);
    }

    /**
     * 返回失败，自定义
     */
    public static <T> APIResponse<T> error(CodeEnum codeEnum, T t) {
        return new APIResponse(codeEnum.getCode(), codeEnum.getMessage(), t);
    }

    /**
     * 返回失败，自定义
     */
    public static <T> APIResponse<T> error(CodeEnum codeEnum, String msg) {
        return new APIResponse(codeEnum.getCode(), msg, null);
    }


    /**
     * 返回失败，自定义
     */
    public static <T> APIResponse<T> error(CodeEnum codeEnum, String msg, T t) {
        return new APIResponse(codeEnum.getCode(), msg, t);
    }

    /**
     * 返回失败，自定义
     */
    public static <T> APIResponse<T> errorInfo(CodeEnum codeEnum, String msg) {
        return new APIResponse(codeEnum.getCode(), msg, null);
    }

    /**
     * 返回失败，自定义
     */
    public static <T> APIResponse<T> error(String msg) {
        return new APIResponse(CodeEnum.ERROR.getCode(), msg, null);
    }

    /**
     * 返回失败，自定义
     */
    public static <T> APIResponse<T> error(CodeEnum codeEnum) {
        return new APIResponse(codeEnum.getCode(), codeEnum.getMessage(), null);
    }

    /**
     * 返回失败，自定义
     */
    public static <T> APIResponse<T> errorFormat(CodeEnum codeEnum, String... str) {
        return new APIResponse(codeEnum.getCode(), String.format(codeEnum.getMessage(), str), null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String message) {
        this.msg = message;
    }

    /**
     * @return the model
     */
    public T getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(T model) {
        this.model = model;
    }

    /**
     * @return the traceId
     */
    /*public String getTraceId() {
        if (!SpringUtil.containsBean("tracer")) {
            return null;
        }
        Tracer tracer = SpringUtil.getBean(Tracer.class);
        if (!CheckUtils.isEmpty(tracer) && !CheckUtils.isEmpty(tracer.currentSpan()) && !CheckUtils.isEmpty(tracer.currentSpan().context())) {
            traceId = tracer.currentSpan().context().traceIdString();
        }
        return traceId;
    }

    *//**
     * @param traceId the traceId to set
     *//*
    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }*/
}
