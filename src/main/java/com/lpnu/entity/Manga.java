package com.lpnu.entity;

import java.util.Map;

public class Manga {
    private Long id;
    private String title;
    private String author;
    private Double rating;
    private Map<Double, Integer> chapters;

    public Manga() {
    }

    public Manga(final Long id, final String title, final Double rating, final String author,
                 final Map<Double, Integer> chapters) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.author = author;
        this.chapters = chapters;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(final Double rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public Map<Double, Integer> getChapters() {
        return chapters;
    }

    public void setChapters(final Map<Double, Integer> chapters) {
        this.chapters = chapters;
    }
}
