package com.nghiem.market.dto;

import java.util.List;

public class ResponseApi<T> {
    public int code;
    public String message;
    public List<Object> options;

    public T Data;
    public ResponseApi(int code, String message, List<Object> options, T data) {
        this.code = code;
        this.message = message;
        this.options = options;
        Data = data;
    }


}
