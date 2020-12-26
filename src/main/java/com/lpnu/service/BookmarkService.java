package com.lpnu.service;

import com.lpnu.dto.BookmarkDTO;

import java.util.List;

public interface BookmarkService {
    BookmarkDTO getBookmarkByMangaAndUserId(Long mangaId, Long userId);
    List<BookmarkDTO> getBookmarksByUserId(Long userId);
    List<BookmarkDTO> getWantToReadBookmarksByUserId(Long userId);
    List<BookmarkDTO> getNowReadingBookmarksByUserId(Long userId);
    List<BookmarkDTO> getAlreadyReadBookmarksByUserId(Long userId);
    List<BookmarkDTO> getAllBookmarks();
    List<BookmarkDTO> getAllWantToReadBookmarks();
    List<BookmarkDTO> getAllNowReadingBookmarks();
    List<BookmarkDTO> getAllAlreadyReadBookmarks();
    BookmarkDTO createBookmark(BookmarkDTO bookmarkDTO, Long userId, Long mangaId);
    BookmarkDTO updateBookmark(BookmarkDTO bookmarkDTO, Long userId, Long mangaId);
    void deleteBookmarkByMangaAndUserId(Long mangaId, Long userId);
    void deleteBookmarkSByUserId(Long userId);
}
