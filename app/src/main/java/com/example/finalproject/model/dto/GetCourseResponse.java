package com.example.finalproject.model.dto;

import com.example.finalproject.model.entity.User;

public class GetCourseResponse {
    private String _id;
    private String title;
    private int rating;
    private String description;
    private int price;
    private int discountPercent;
    private String thumbnailUrl;
    private String createdAt;
    private String updatedAt;
    private String outcome;
    private int courseStatus;
    private int totalLesson;
    private int level;
    private String categoryId;
    private User lectureId;

    public GetCourseResponse(String _id, String title, int rating, String description, int price, int discountPercent, String thumbnailUrl, String createdAt, String updatedAt, String outcome, int courseStatus, int totalLesson, int level, String categoryId, User lectureId) {
        this._id = _id;
        this.title = title;
        this.rating = rating;
        this.description = description;
        this.price = price;
        this.discountPercent = discountPercent;
        this.thumbnailUrl = thumbnailUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.outcome = outcome;
        this.courseStatus = courseStatus;
        this.totalLesson = totalLesson;
        this.level = level;
        this.categoryId = categoryId;
        this.lectureId = lectureId;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
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

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public int getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(int courseStatus) {
        this.courseStatus = courseStatus;
    }

    public int getTotalLesson() {
        return totalLesson;
    }

    public void setTotalLesson(int totalLesson) {
        this.totalLesson = totalLesson;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public User getLectureId() {
        return lectureId;
    }

    public void setLectureId(User lectureId) {
        this.lectureId = lectureId;
    }
}
