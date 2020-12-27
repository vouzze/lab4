package com.lpnu.service;

import com.lpnu.model.BookmarkDTO;

import java.util.List;

public interface BookmarkService {
    BookmarkDTO getBookmarkByMangaAndUserId(Long userId, Long mangaId);
    List<BookmarkDTO> getBookmarksByUserId(Long userId);
    List<BookmarkDTO> getWantToReadBookmarksByUserId(Long userId);
    List<BookmarkDTO> getNowReadingBookmarksByUserId(Long userId);
    List<BookmarkDTO> getAlreadyReadBookmarksByUserId(Long userId);
    List<BookmarkDTO> getBookmarksByMangaId(Long mangaId);
    List<BookmarkDTO> getWantToReadBookmarksByMangaId(Long mangaId);
    List<BookmarkDTO> getNowReadingBookmarksByMangaId(Long mangaId);
    List<BookmarkDTO> getAlreadyReadBookmarksByMangaId(Long mangaId);
    List<BookmarkDTO> getAllBookmarks();
    List<BookmarkDTO> getAllWantToReadBookmarks();
    List<BookmarkDTO> getAllNowReadingBookmarks();
    List<BookmarkDTO> getAllAlreadyReadBookmarks();
    BookmarkDTO createBookmark(BookmarkDTO bookmarkDTO, Long userId, Long mangaId);
    BookmarkDTO updateBookmark(BookmarkDTO bookmarkDTO, Long userId, Long mangaId);
    void deleteBookmarkByMangaAndUserId(Long userId, Long mangaId);
    void deleteBookmarksByUserId(Long userId);
    void deleteBookmarksByMangaId(Long mangaId);
}
