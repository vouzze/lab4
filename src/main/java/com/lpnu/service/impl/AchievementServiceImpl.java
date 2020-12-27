package com.lpnu.service.impl;

import com.lpnu.model.enumeration.Achievement;
import com.lpnu.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BookmarkServiceImpl bookmarkService;

    @PostConstruct
    public void init() {
        savedAchievements = new HashMap<>();
    }

    private Map<Long, List<String>> savedAchievements;

    @Override
    public List<String> getAllAchievementsByUserId(final Long userId) {
        return savedAchievements.get(userId);
    }

    @Override
    public Integer getAllBookmarksQuantityByUserId(final Long userId) {
        return bookmarkService.getBookmarksByUserId(userId).size();
    }

    @Override
    public Integer getWantToReadBookmarksQuantityByUserId(final Long userId) {
        return bookmarkService.getWantToReadBookmarksByUserId(userId).size();
    }

    @Override
    public Integer getNowReadingBookmarksQuantityByUserId(final Long userId) {
        return bookmarkService.getNowReadingBookmarksByUserId(userId).size();
    }

    @Override
    public Integer getAlreadyReadBookmarksQuantityByUserId(final Long userId) {
        return bookmarkService.getAlreadyReadBookmarksByUserId(userId).size();
    }

    @Override
    public Integer getAllBookmarksQuantityByMangaId(final Long mangaId) {
        return bookmarkService.getBookmarksByMangaId(mangaId).size();
    }

    @Override
    public Integer getWantToReadBookmarksQuantityByMangaId(final Long mangaId) {
        return bookmarkService.getWantToReadBookmarksByMangaId(mangaId).size();
    }

    @Override
    public Integer getNowReadingBookmarksQuantityByMangaId(final Long mangaId) {
        return bookmarkService.getNowReadingBookmarksByMangaId(mangaId).size();
    }

    @Override
    public Integer getAlreadyReadBookmarksQuantityByMangaId(final Long mangaId) {
        return bookmarkService.getAlreadyReadBookmarksByMangaId(mangaId).size();
    }

    @Override
    public List<String> addAchievementsByUserId(final Long userId) {

        userService.getUserById(userId);

        if (!savedAchievements.containsKey(userId)) {
            savedAchievements.put(userId, new ArrayList<>(Collections.singleton(Achievement.INTRUDER.toString())));
        }

        if (getWantToReadBookmarksQuantityByUserId(userId) >= 3 &&
                !savedAchievements.get(userId).contains(Achievement.PROPHET.toString())) {
            savedAchievements.get(userId).add(Achievement.PROPHET.toString());
        }

        if (getNowReadingBookmarksQuantityByUserId(userId) >= 3 &&
                !savedAchievements.get(userId).contains(Achievement.BOOKMARKER.toString())) {
            savedAchievements.get(userId).add(Achievement.BOOKMARKER.toString());
        }

        if (getAlreadyReadBookmarksQuantityByUserId(userId) >= 3 &&
                !savedAchievements.get(userId).contains(Achievement.EXPERT.toString())) {
            savedAchievements.get(userId).add(Achievement.EXPERT.toString());
        }

        if (getAllBookmarksQuantityByUserId(userId) >= 10 &&
                !savedAchievements.get(userId).contains(Achievement.OVERLORD.toString())) {
            savedAchievements.get(userId).add(Achievement.OVERLORD.toString());
        }

        savedAchievements.replace(userId, savedAchievements.get(userId));

        return savedAchievements.get(userId);
    }
}