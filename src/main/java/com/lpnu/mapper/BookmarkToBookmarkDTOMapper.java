package com.lpnu.mapper;

import com.lpnu.dto.BookmarkDTO;
import com.lpnu.entity.Bookmark;
import com.lpnu.entity.User;

public class BookmarkToBookmarkDTOMapper {

    public Bookmark toEntity(final BookmarkDTO bookmarkDTO, final User user) {
        if (user == null) {
            //todo custom exception
        }
        final Bookmark bookmark = new Bookmark();

        bookmark.setManga(bookmarkDTO.getManga());
        bookmark.setStatus(bookmarkDTO.getStatus());
        bookmark.setRating(bookmarkDTO.getRating());
        bookmark.setChapter(bookmarkDTO.getChapter());
        bookmark.setPage(bookmarkDTO.getPage());
        bookmark.setUser(user);

        return bookmark;
    }

    public BookmarkDTO toDTO(final Bookmark bookmark) {
        final BookmarkDTO bookmarkDTO = new BookmarkDTO();

        bookmarkDTO.setManga(bookmark.getManga());
        bookmarkDTO.setStatus(bookmark.getStatus());
        bookmarkDTO.setRating(bookmark.getRating());
        bookmarkDTO.setChapter(bookmark.getChapter());
        bookmarkDTO.setPage(bookmark.getPage());

        return bookmarkDTO;
    }

}
