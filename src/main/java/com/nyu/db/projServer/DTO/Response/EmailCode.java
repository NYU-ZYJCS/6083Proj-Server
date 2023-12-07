package com.nyu.db.projServer.DTO.Response;

/**
 * @Author: yingjie
 * @Description: TODO
 * @CreateTime: 2023/12/6 11:09
 */
public class EmailCode {

    private String code;

    private Long expirationTime;

    public EmailCode(String code, Long expirationTime) {
        this.code = code;
        this.expirationTime = expirationTime;
    }

    public EmailCode() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }
}
