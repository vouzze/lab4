package com.lpnu.mapper;

import com.lpnu.dto.BookmarkDTO;
import com.lpnu.entity.Bookmark;
import com.lpnu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookmarkToBookmarkDTOMapper {
    @Autowired
    private MangaToMangaDTOMapper mangaMapper;
    @Autowired
    private UserRepository userRepository;

    public Bookmark toEntity(final BookmarkDTO bookmarkDTO, final Long userId) {
        if (userId == null) {
            //todo custom exception
        }
        final Bookmark bookmark = new Bookmark();

        bookmark.setManga(mangaMapper.toEntity(bookmarkDTO.getMangaDTO()));
        bookmark.setStatus(bookmarkDTO.getStatus());
        bookmark.setRating(bookmarkDTO.getRating());
        bookmark.setChapter(bookmarkDTO.getChapter());
        bookmark.setPage(bookmarkDTO.getPage());
        bookmark.setUser(userRepository.getUserById(userId));

        return bookmark;
    }

    public BookmarkDTO toDTO(final Bookmark bookmark) {
        final BookmarkDTO bookmarkDTO = new BookmarkDTO();

        bookmarkDTO.setMangaDTO(mangaMapper.toDTO(bookmark.getManga()));
        bookmarkDTO.setStatus(bookmark.getStatus());
        bookmarkDTO.setRating(bookmark.getRating());
        bookmarkDTO.setChapter(bookmark.getChapter());
        bookmarkDTO.setPage(bookmark.getPage());

        return bookmarkDTO;
    }

}
