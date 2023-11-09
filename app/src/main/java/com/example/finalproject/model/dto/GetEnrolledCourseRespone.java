package com.example.finalproject.model.dto;

import com.example.finalproject.model.entity.Course;

public class GetEnrolledCourseRespone {
    private String _id;
    private String studentId;
    private Course courseId;
    private String createdAt;
    private String updatedAt;
    private int totalCompleteLesson;

    public GetEnrolledCourseRespone() {
    }

    public GetEnrolledCourseRespone(String _id, String studentId, Course courseId, String createdAt, String updatedAt, int totalCompleteLesson) {
        this._id = _id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.totalCompleteLesson = totalCompleteLesson;
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

    public int getTotalCompleteLesson() {
        return totalCompleteLesson;
    }

    public void setTotalCompleteLesson(int totalCompleteLesson) {
        this.totalCompleteLesson = totalCompleteLesson;
    }
}
