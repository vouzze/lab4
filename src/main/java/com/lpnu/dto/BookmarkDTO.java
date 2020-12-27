package com.lpnu.dto;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.PositiveOrZero;

public class BookmarkDTO {
    private MangaDTO manga;
    private String status;
    @DecimalMin("0.0")
    @DecimalMax("5.0")
    private Double rating;
    @PositiveOrZero
    private Double chapter;
    @PositiveOrZero
    private Integer page;

    public BookmarkDTO() {
    }

    public BookmarkDTO(final MangaDTO manga) {
        this.manga = manga;
        this.status = "want to read";
    }

    public BookmarkDTO(final MangaDTO manga, final @Valid Double chapter, final @Valid Integer page) {
        this.manga = manga;
        this.status = "now reading";
        this.chapter = chapter;
        this.page = page;
    }

    public BookmarkDTO(final MangaDTO manga, final @Valid Double rating) {
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

    public void setRating(final @Valid Double rating) {
        this.rating = rating;
    }

    public Double getChapter() {
        return chapter;
    }

    public void setChapter(final @Valid Double chapter) {
        this.chapter = chapter;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(final @Valid Integer page) {
        this.page = page;
    }
}
