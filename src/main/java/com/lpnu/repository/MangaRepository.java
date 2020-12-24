package com.lpnu.repository;

import com.lpnu.entity.Manga;
import com.lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MangaRepository {
    @PostConstruct
    public void init(){
        savedMangas = new ArrayList<>();
    }

    private static Long lastId = 1L;
    private List<Manga> savedMangas;

    public Manga getMangaById(final Long id) {
        return savedMangas.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Manga with id: " + id + " not found ", null));
    }

    public List<Manga> getAllMangas() {
        return savedMangas;
    }

    public Manga createManga(final Manga manga) {
        if(manga.getId() != null){
            throw new ServiceException(400, "Manga shouldn't have an id ", null);
        }

        ++lastId;
        manga.setId(lastId);

        savedMangas.add(manga);

        return manga;
    }

    public Manga updateManga(final Manga manga) {
        if(manga.getId() == null){
            throw new ServiceException(400, "User should have an id ", null);
        }

        final Manga savedManga = getMangaById(manga.getId());

        savedManga.setTitle(manga.getTitle());
        savedManga.setAuthorName(manga.getAuthorName());
        savedManga.setRating(manga.getRating());

        return savedManga;
    }

    public void deleteMangaById(final Long id) {
        if(id == null){
            throw new ServiceException(400, "Id isn't specified", null);
        }

        savedMangas.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Manga with id: " + id + " not found ", null));

        savedMangas = savedMangas.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

    }
}
