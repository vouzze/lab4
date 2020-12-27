package com.lpnu.entity;

public class Bookmark {
    Manga manga;
    private String status;
    private Double rating;
    private Double chapter;
    private Integer page;
    private User user;

    public Bookmark() {
    }

    public Bookmark(final Manga manga, final User user) {
        this.manga = manga;
        this.status = "want to read";
        this.user = user;
    }

    public Bookmark(final Manga manga, final Double chapter, final Integer page, final User user) {
        this.manga = manga;
        this.status = "now reading";
        this.chapter = chapter;
        this.page = page;
        this.user = user;
    }

    public Bookmark(final Manga manga, final Double rating, final User user) {
        this.manga = manga;
        this.status = "already read";
        this.rating = rating;
        this.user = user;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(final Manga manga) {
        this.manga = manga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(final Double rating) {
        this.rating = rating;
    }

    public Double getChapter() {
        return chapter;
    }

    public void setChapter(final Double chapter) {
        this.chapter = chapter;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(final Integer page) {
        this.page = page;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }
}
