package com.lpnu.service;

import com.lpnu.dto.BookmarkDTO;

import java.util.List;

public interface BookmarkService {
    BookmarkDTO getBookmarkByMangaAndUserId(Long mangaId, Long userId);
    List<BookmarkDTO> getBookmarksByUserId(Long userId);
    List<BookmarkDTO> getAllBookmarks();
    BookmarkDTO createBookmark(BookmarkDTO bookmarkDTO, Long userId);
    BookmarkDTO updateBookmark(BookmarkDTO bookmarkDTO, Long userId);
    void deleteBookmarkByMangaAndUserId(Long mangaId, Long userId);
    void deleteBookmarkSByUserId(Long userId);
}
