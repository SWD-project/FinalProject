package com.example.finalproject.model.dto;

import com.example.finalproject.model.entity.Course;

public class GetTransactionRespone {
    private String _id;
    private String studentId;
    private Course courseId;
    private int payment;
    private int total;
    private String createdAt;
    private String updatedAt;

    // Constructors

    public GetTransactionRespone(String _id, String studentId, Course courseId, int payment, int total, String createdAt, String updatedAt) {
        this._id = _id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.payment = payment;
        this.total = total;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    // Getters and Setters

}
