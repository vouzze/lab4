package com.lpnu.dto;

import javax.validation.constraints.*;
import java.util.Map;

public class MangaDTO {
    private Long id;
    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    private String title;
    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    private String author;
    @DecimalMin("0.0")
    @DecimalMax("5.0")
    private Double rating;
    private Map<@PositiveOrZero Double, @PositiveOrZero Integer> chapters;

    public MangaDTO() {
    }

    public MangaDTO(final Long id, final String title, final Double rating, final String author,
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
