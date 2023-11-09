package com.example.finalproject.model.dto;

import com.example.finalproject.model.entity.Course;

public class GetTransactionRespone {
    private int _id;
    private String studentId;
    private Course courseId;
    private double payment;
    private double total;
    private String createdAt;
    private String updatedAt;

    // Constructors
    public GetTransactionRespone() {
    }

    public GetTransactionRespone(int _id, String studentId, Course courseId, double payment, double total, String createdAt, String updatedAt) {
        this._id = _id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.payment = payment;
        this.total = total;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
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

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
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
}
