package com.example.finalproject.model.dto;

import com.example.finalproject.model.entity.Course;

public class CartDetailResponse {
    private String _id;
    private String cartId;
    private Course courseId;
    private String createdAt;
    private String updatedAt;

    public CartDetailResponse(String _id, String cartId, Course courseId, String createdAt, String updatedAt) {
        this._id = _id;
        this.cartId = cartId;
        this.courseId = courseId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public String getCreateAt() {
        return createdAt;
    }

    public void setCreateAt(String createAt) {
        this.createdAt = createAt;
    }

    public String getUpdateAt() {
        return updatedAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updatedAt = updateAt;
    }
}
