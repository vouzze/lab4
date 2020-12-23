package com.lpnu.entity;

public class Bookmark {
    Manga manga;
    private String status;
    private double rating;
    private double chapter;
    private int page;
    private User user;

    public Bookmark() {
    }

    public Bookmark(final Manga manga, final User user) {
        this.manga = manga;
        this.status = "want to read";
        this.user = user;
    }

    public Bookmark(final Manga manga, final double chapter, final int page, final User user) {
        this.manga = manga;
        this.status = "now reading";
        this.chapter = chapter;
        this.page = page;
        this.user = user;
    }

    public Bookmark(final Manga manga, final double rating, final User user) {
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

    public double getRating() {
        return rating;
    }

    public void setRating(final double rating) {
        this.rating = rating;
    }

    public double getChapter() {
        return chapter;
    }

    public void setChapter(final double chapter) {
        this.chapter = chapter;
    }

    public int getPage() {
        return page;
    }

    public void setPage(final int page) {
        this.page = page;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }
}
