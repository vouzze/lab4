package com.lpnu.service;

import java.util.List;

public interface AchievementService {

    List<String> getAllAchievementsByUserId(Long userId);

    Integer getAllBookmarksQuantityByUserId(Long userId);

    Integer getWantToReadBookmarksQuantityByUserId(Long userId);

    Integer getNowReadingBookmarksQuantityByUserId(Long userId);

    Integer getAlreadyReadBookmarksQuantityByUserId(Long userId);

    Integer getAllBookmarksQuantityByMangaId(Long mangaId);

    Integer getWantToReadBookmarksQuantityByMangaId(Long mangaId);

    Integer getNowReadingBookmarksQuantityByMangaId(Long mangaId);

    Integer getAlreadyReadBookmarksQuantityByMangaId(Long mangaId);

    List<String> addAchievementsByUserId(Long userId);
}
