package com.fuxun.http.base;

import java.io.Serializable;

/**
 * 服务器返回公共实体
 *
 * @author twilight
 * @since 2021/7/1
 */
public class BaseDto<T> implements Serializable {

    // 返回码
    private String statusCode;

    // 描述
    private String statusDesc;

    // 数据
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
