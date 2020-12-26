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

    @GetMapping("/achievements/all-bookmarks/{id}")
    public Integer getAllBookmarksQuantityByUserId(final @PathVariable Long id) {
        return achievementService.getAllBookmarksQuantityByUserId(id);
    }

    @GetMapping("/achievements/want-to-read-bookmarks/{id}")
    public Integer getWantToReadBookmarksQuantityByUserId(final @PathVariable Long id) {
        return achievementService.getWantToReadBookmarksQuantityByUserId(id);
    }

    @GetMapping("/achievements/now-reading-bookmarks/{id}")
    public Integer getNowReadingBookmarksQuantityByUserId(final @PathVariable Long id) {
        return achievementService.getNowReadingBookmarksQuantityByUserId(id);
    }

    @GetMapping("/achievements/already-read-bookmarks/{id}")
    public Integer getAlreadyReadBookmarksQuantityByUserId(final @PathVariable Long id) {
        return achievementService.getAlreadyReadBookmarksQuantityByUserId(id);
    }

    @PostMapping("/achievements/{id}")
    public List<String> addAchievementsByUserId(final @PathVariable Long id) {
        return achievementService.addAchievementsByUserId(id);
    }

}