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
    private String code;

    // 描述
    private String message;

    // 数据
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
