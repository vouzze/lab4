package com.lpnu.repository;

import com.lpnu.entity.Bookmark;
import com.lpnu.entity.Manga;
import com.lpnu.exception.ServiceException;
import com.lpnu.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MangaRepository {
    @Autowired
    private BookmarkRepository bookmarkRepository;
    @Autowired
    private AchievementService achievementService;

    @PostConstruct
    public void init() {
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
        if (manga.getId() != null) {
            throw new ServiceException(400, "Manga shouldn't have an id ", null);
        } else if (manga.getRating() != null) {
            throw new ServiceException(400, "Manga shouldn't have a rating", null);
        }

        ++lastId;
        manga.setId(lastId);

        savedMangas.add(manga);

        return manga;
    }

    public Manga updateManga(final Manga manga) {
        if (manga.getId() == null) {
            throw new ServiceException(400, "User should have an id ", null);
        } else if (manga.getRating() != null) {
            throw new ServiceException(400, "Manga shouldn't have a rating", null);
        }

        final Manga savedManga = getMangaById(manga.getId());

        savedManga.setTitle(manga.getTitle());
        savedManga.setAuthor(manga.getAuthor());
        if (achievementService.getAlreadyReadBookmarksQuantityByMangaId(manga.getId()) > 0) {
            final double ratingAverage = bookmarkRepository.getAlreadyReadBookmarksByMangaId(manga.getId()).stream()
                    .mapToDouble(Bookmark::getRating).average().getAsDouble();

            savedManga.setRating(Math.round(ratingAverage * 10.0) / 10.0);
        } else {
            savedManga.setRating(0.0);
        }
        savedManga.setChapters(manga.getChapters());

        return savedManga;
    }

    public void deleteMangaById(final Long id) {
        if (id == null) {
            throw new ServiceException(400, "Id isn't specified", null);
        }

        savedMangas.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Manga with id: " + id + " not found ", null));

        savedMangas = savedMangas.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

        if (achievementService.getAllBookmarksQuantityByMangaId(id) > 0) {
            bookmarkRepository.deleteBookmarksByMangaId(id);
        }
    }
}
