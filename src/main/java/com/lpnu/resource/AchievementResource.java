package com.lpnu.resource;

import com.lpnu.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AchievementResource {

    @Autowired
    public AchievementService achievementService;

    @GetMapping("/achievements/{id}")
    public List<String> getAllAchievementsByUserId(final @PathVariable Long id) {
        return achievementService.getAllAchievementsByUserId(id);
    }

    @GetMapping("/achievements/all-bookmarks/user/{userId}")
    public Integer getAllBookmarksQuantityByUserId(final @PathVariable Long userId) {
        return achievementService.getAllBookmarksQuantityByUserId(userId);
    }

    @GetMapping("/achievements/want-to-read-bookmarks/user/{userId}")
    public Integer getWantToReadBookmarksQuantityByUserId(final @PathVariable Long userId) {
        return achievementService.getWantToReadBookmarksQuantityByUserId(userId);
    }

    @GetMapping("/achievements/now-reading-bookmarks/user/{userId}")
    public Integer getNowReadingBookmarksQuantityByUserId(final @PathVariable Long userId) {
        return achievementService.getNowReadingBookmarksQuantityByUserId(userId);
    }

    @GetMapping("/achievements/already-read-bookmarks/user/{userId}")
    public Integer getAlreadyReadBookmarksQuantityByUserId(final @PathVariable Long userId) {
        return achievementService.getAlreadyReadBookmarksQuantityByUserId(userId);
    }

    @GetMapping("/achievements/all-bookmarks/manga/{mangaId}")
    public Integer getAllBookmarksQuantityByMangaId(final @PathVariable Long mangaId) {
        return achievementService.getAllBookmarksQuantityByMangaId(mangaId);
    }

    @GetMapping("/achievements/want-to-read-bookmarks/manga/{mangaId}")
    public Integer getWantToReadBookmarksQuantityByMangaId(final @PathVariable Long mangaId) {
        return achievementService.getWantToReadBookmarksQuantityByMangaId(mangaId);
    }

    @GetMapping("/achievements/now-reading-bookmarks/manga/{mangaId}")
    public Integer getNowReadingBookmarksQuantityByMangaId(final @PathVariable Long mangaId) {
        return achievementService.getNowReadingBookmarksQuantityByMangaId(mangaId);
    }

    @GetMapping("/achievements/already-read-bookmarks/manga/{mangaId}")
    public Integer getAlreadyReadBookmarksQuantityByMangaId(final @PathVariable Long mangaId) {
        return achievementService.getAlreadyReadBookmarksQuantityByUserId(mangaId);
    }

    @PostMapping("/achievements/{id}")
    public List<String> addAchievementsByUserId(final @PathVariable Long id) {
        return achievementService.addAchievementsByUserId(id);
    }

}