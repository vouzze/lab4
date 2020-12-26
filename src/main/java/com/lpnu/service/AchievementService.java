package com.lpnu.service;

import java.util.List;

public interface AchievementService {

    List<String> getAllAchievementsByUserId(Long userId);

    Integer getAllBookmarksQuantityByUserId(Long userId);

    Integer getWantToReadBookmarksQuantityByUserId(Long userId);

    Integer getNowReadingBookmarksQuantityByUserId(Long userId);

    Integer getAlreadyReadBookmarksQuantityByUserId(Long userId);

    List<String> addAchievementsByUserId(Long userId);
}
