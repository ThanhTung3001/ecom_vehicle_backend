package com.nghiem.market.dto;

import java.util.List;

public class ResponseApi<T> {
    public int code;
    public String message;
    public List<Object> options;

    public T data;
    public ResponseApi(int code, String message, List<Object> options, T data) {
        this.code = code;
        this.message = message;
        this.options = options;
        this.data = data;
    }


}
