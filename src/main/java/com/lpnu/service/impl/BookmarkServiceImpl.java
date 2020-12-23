package com.lpnu.service.impl;

import com.lpnu.dto.BookmarkDTO;
import com.lpnu.service.BookmarkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService {
    @Override
    public BookmarkDTO getBookmarkByMangaAndUserId(final Long mangaId, final Long userId) {
        return null;
    }

    @Override
    public List<BookmarkDTO> getAllBookmarks() {
        return null;
    }

    @Override
    public BookmarkDTO createBookmark(final BookmarkDTO userDTO) {
        return null;
    }

    @Override
    public BookmarkDTO updateBookmark(final BookmarkDTO userDTO) {
        return null;
    }

    @Override
    public void deleteBookmarkByMangaAndUserId(final Long mangaId, final Long userId) {

    }
}
