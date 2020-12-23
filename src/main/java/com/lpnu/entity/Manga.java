package com.lpnu.entity;

public class Manga {
    private Long id;
    private String title;
    private String authorName;
    private double rating;

    public Manga() {
    }

    public Manga(final Long id, final String title, final double rating, final String authorName) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.authorName = authorName;
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

    public double getRating() {
        return rating;
    }

    public void setRating(final double rating) {
        this.rating = rating;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(final String authorName) {
        this.authorName = authorName;
    }
}
