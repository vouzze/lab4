package com.lpnu.dto;

public class BookmarkDTO {
    private MangaDTO manga;
    private String status;
    private Double rating;
    private Double chapter;
    private Integer page;

    public BookmarkDTO() {
    }

    public BookmarkDTO(final MangaDTO manga) {
        this.manga = manga;
        this.status = "want to read";
    }

    public BookmarkDTO(final MangaDTO manga, final Double chapter, final Integer page) {
        this.manga = manga;
        this.status = "now reading";
        this.chapter = chapter;
        this.page = page;
    }

    public BookmarkDTO(final MangaDTO manga, final Double rating) {
        this.manga = manga;
        this.status = "already read";
        this.rating = rating;
    }

    public MangaDTO getManga() {
        return manga;
    }

    public void setManga(final MangaDTO manga) {
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
}
