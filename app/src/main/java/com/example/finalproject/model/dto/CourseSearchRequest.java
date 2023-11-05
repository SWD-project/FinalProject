package com.example.finalproject.model.dto;

import java.util.Optional;

public class CourseSearchRequest {
    private String title;
    private String[] categories;
    private int[] levels;
    private Optional<Integer> page;
    private Optional<Integer> limit;

    public CourseSearchRequest(String title, String[] categories, int[] levels, Optional<Integer> page, Optional<Integer> limit) {
        this.title = title;
        this.categories = categories;
        this.levels = levels;
        this.page = page;
        this.limit = limit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public int[] getLevels() {
        return levels;
    }

    public void setLevels(int[] levels) {
        this.levels = levels;
    }

    public Optional<Integer> getPage() {
        return page;
    }

    public void setPage(Optional<Integer> page) {
        this.page = page;
    }

    public Optional<Integer> getLimit() {
        return limit;
    }

    public void setLimit(Optional<Integer> limit) {
        this.limit = limit;
    }
}
