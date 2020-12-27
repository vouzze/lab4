package com.lpnu.mapper;

import com.lpnu.model.MangaDTO;
import com.lpnu.entity.Manga;
import org.springframework.stereotype.Component;

@Component
public class MangaToMangaDTOMapper {
    public Manga toEntity(final MangaDTO mangaDTO){
        final Manga manga = new Manga();

        manga.setId(mangaDTO.getId());
        manga.setTitle(mangaDTO.getTitle());
        manga.setAuthor(mangaDTO.getAuthor());
        manga.setRating(mangaDTO.getRating());
        manga.setChapters(mangaDTO.getChapters());

        return manga;
    }

    public MangaDTO toDTO(final Manga manga){
        final MangaDTO mangaDTO = new MangaDTO();

        mangaDTO.setId(manga.getId());
        mangaDTO.setTitle(manga.getTitle());
        mangaDTO.setAuthor(manga.getAuthor());
        mangaDTO.setRating(manga.getRating());
        mangaDTO.setChapters(manga.getChapters());

        return mangaDTO;
    }
}
