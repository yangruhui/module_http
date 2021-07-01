package com.fuxun.http.exception;

/**
 * 前端自定义Exception
 *
 * @author twilight
 * @since 2021/7/1
 */
public class ApiException extends Exception {

    // 错误码
    private String statusCode;

    // 错误描述
    private String statusDesc;

    public ApiException(Throwable throwable, String statusCode) {
        super(throwable);
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
