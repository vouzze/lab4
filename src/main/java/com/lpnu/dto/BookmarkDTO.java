package com.lpnu.dto;

import com.lpnu.entity.Manga;

public class BookmarkDTO {
    Manga manga;
    private String status;
    private double rating;
    private double chapter;
    private int page;

    public BookmarkDTO() {
    }

    public BookmarkDTO(final Manga manga, final String status) {
        this.manga = manga;
        this.status = status;
    }

    public BookmarkDTO(final Manga manga, final String status, final double chapter, final int page) {
        this.manga = manga;
        this.status = status;
        this.chapter = chapter;
        this.page = page;
    }

    public BookmarkDTO(final Manga manga, final String status, final double rating) {
        this.manga = manga;
        this.status = status;
        this.rating = rating;
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
}
