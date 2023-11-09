package com.example.finalproject.model.dto;

import com.example.finalproject.model.entity.Course;

public class GetCartResponse {
    private String _id;
    private String cartId;
    private Course courseId;
    private String createAt;
    private String updateAt;

    public GetCartResponse(String _id, String cartId, Course courseId, String createAt, String updateAt) {
        this._id = _id;
        this.cartId = cartId;
        this.courseId = courseId;
        this.createAt = createAt;
        this.updateAt = updateAt;
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
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
