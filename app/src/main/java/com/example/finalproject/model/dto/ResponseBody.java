package com.example.finalproject.model.dto;

import java.util.List;

public class ResponseBody <T>{
    private List<T> data;
    private String message;
    private String status;

    public ResponseBody() {
    }

    public ResponseBody(List<T> data, String message, String status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
