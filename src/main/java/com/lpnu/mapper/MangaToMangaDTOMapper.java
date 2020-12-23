package com.lpnu.mapper;

import com.lpnu.dto.MangaDTO;
import com.lpnu.entity.Manga;
import org.springframework.stereotype.Component;

@Component
public class MangaToMangaDTOMapper {
    public Manga toEntity(final MangaDTO mangaDTO){
        final Manga manga = new Manga();

        manga.setId(mangaDTO.getId());
        manga.setTitle(mangaDTO.getTitle());
        manga.setAuthorName(mangaDTO.getAuthorName());
        manga.setRating(mangaDTO.getRating());

        return manga;
    }

    public MangaDTO toDTO(final Manga manga){
        final MangaDTO mangaDTO = new MangaDTO();

        mangaDTO.setId(manga.getId());
        mangaDTO.setTitle(manga.getTitle());
        mangaDTO.setAuthorName(manga.getAuthorName());
        mangaDTO.setRating(manga.getRating());

        return mangaDTO;
    }
}
