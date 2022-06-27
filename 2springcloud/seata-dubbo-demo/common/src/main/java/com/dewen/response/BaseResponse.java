package com.dewen.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 基本返回
 */
@Data
public class BaseResponse implements Serializable {

    private int status = 200;

    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
