package com.lpnu.dto;

import com.lpnu.entity.Manga;

public class BookmarkDTO {
    private MangaDTO mangaDTO;
    private String status;
    private Double rating;
    private Double chapter;
    private Integer page;

    public BookmarkDTO() {
    }

    public BookmarkDTO(final MangaDTO mangaDTO, final String status) {
        this.mangaDTO = mangaDTO;
        this.status = status;
    }

    public BookmarkDTO(final MangaDTO mangaDTO, final String status, final Double chapter, final Integer page) {
        this.mangaDTO = mangaDTO;
        this.status = status;
        this.chapter = chapter;
        this.page = page;
    }

    public BookmarkDTO(final MangaDTO mangaDTO, final String status, final Double rating) {
        this.mangaDTO = mangaDTO;
        this.status = status;
        this.rating = rating;
    }

    public MangaDTO getMangaDTO() {
        return mangaDTO;
    }

    public void setMangaDTO(final MangaDTO mangaDTO) {
        this.mangaDTO = mangaDTO;
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
