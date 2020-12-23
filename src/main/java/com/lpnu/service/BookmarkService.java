package com.lpnu.service;

import com.lpnu.dto.BookmarkDTO;

import java.util.List;

public interface BookmarkService {
    BookmarkDTO getBookmarkByMangaAndUserId(Long mangaId, Long userId);
    List<BookmarkDTO> getAllBookmarks();
    BookmarkDTO createBookmark(BookmarkDTO userDTO);
    BookmarkDTO updateBookmark(BookmarkDTO userDTO);
    void deleteBookmarkByMangaAndUserId(Long mangaId, Long userId);
}
