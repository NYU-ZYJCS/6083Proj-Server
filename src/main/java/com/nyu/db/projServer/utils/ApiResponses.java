package com.nyu.db.projServer.utils;

public class ApiResponses<T> {
    private T data;
    private String message;
    private Integer code;
    private Boolean success;

    public ApiResponses() {
    }

    public ApiResponses(T data, String message, Integer code, Boolean success) {
        this.data = data;
        this.message = message;
        this.code = code;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
