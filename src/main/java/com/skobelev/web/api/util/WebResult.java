package com.skobelev.web.api.util;

import java.util.Date;

public class WebResult {
    private String message;
    private Date data;

    public WebResult(String message) {
        this.message = message;
        this.data = new Date();
    }

    public String getMessage() {
        return message;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return "WebResult{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
