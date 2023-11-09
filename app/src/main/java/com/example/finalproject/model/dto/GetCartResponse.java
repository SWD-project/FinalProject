package com.example.finalproject.model.dto;

import com.example.finalproject.model.entity.Course;

import java.util.List;

public class GetCartResponse {
    private String id;
    private String studentId;
    private List<CartDetailResponse> cartDetailList;

    public GetCartResponse() {
    }

    public GetCartResponse(String id, String studentId, List<CartDetailResponse> cartDetailList) {
        this.id = id;
        this.studentId = studentId;
        this.cartDetailList = cartDetailList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<CartDetailResponse> getCartDetailList() {
        return cartDetailList;
    }

    public void setCartDetailList(List<CartDetailResponse> cartDetailList) {
        this.cartDetailList = cartDetailList;
    }
}
