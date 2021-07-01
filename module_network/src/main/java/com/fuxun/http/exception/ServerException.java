package com.fuxun.http.exception;

/**
 * 服务器返回Exception
 *
 * @author twilight
 * @since 2021/7/1
 */
public class ServerException extends RuntimeException {

    // 错误码
    private String statusCode;

    // 错误描述
    private String statusDesc;

    public ServerException(String statusCode, String statusDesc) {
        this.statusCode = statusCode;
        this.statusDesc = statusDesc;
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
