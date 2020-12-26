package com.lpnu.service.impl;

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
    public List<String> addAchievementsByUserId(final Long userId) {

        userService.getUserById(userId);

        if (!savedAchievements.containsKey(userId)) {
            savedAchievements.put(userId, new ArrayList<>(Collections.singleton("Newbie")));
        }

        if (getWantToReadBookmarksQuantityByUserId(userId) >= 3) {
            savedAchievements.get(userId).add("Dreamy");
        }

        if (getNowReadingBookmarksQuantityByUserId(userId) >= 3) {
            savedAchievements.get(userId).add("Realistic");
        }

        if (getAlreadyReadBookmarksQuantityByUserId(userId) >= 3) {
            savedAchievements.get(userId).add("Experienced");
        }

        if (getAllBookmarksQuantityByUserId(userId) >= 10) {
            savedAchievements.get(userId).add("Overlord");
        }

        savedAchievements.replace(userId, savedAchievements.get(userId));

        return savedAchievements.get(userId);
    }
}