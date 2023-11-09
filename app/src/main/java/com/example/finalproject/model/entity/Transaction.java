package com.example.finalproject.model.entity;

public class Transaction {
    private String studentId;
    private String courseId;
    private Integer payment;
    private Integer total;

    public Transaction(String studentId, String courseId, Integer payment, Integer total) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.payment = payment;
        this.total = total;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
