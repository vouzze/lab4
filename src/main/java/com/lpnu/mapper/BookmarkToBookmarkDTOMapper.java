package com.lpnu.mapper;

import com.lpnu.dto.BookmarkDTO;
import com.lpnu.entity.Bookmark;
import com.lpnu.exception.ServiceException;
import com.lpnu.repository.MangaRepository;
import com.lpnu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookmarkToBookmarkDTOMapper {
    @Autowired
    private MangaToMangaDTOMapper mangaMapper;
    @Autowired
    private MangaRepository mangaRepository;
    @Autowired
    private UserRepository userRepository;

    public Bookmark toEntity(final BookmarkDTO bookmarkDTO, final Long userId, final Long mangaId) {
        if (userId == null) {
            throw new ServiceException(400, "Bookmark should have a user ", null);
        } else if (mangaId == null) {
            throw new ServiceException(400, "Bookmark should have a manga ", null);
        }
        final Bookmark bookmark = new Bookmark();

        bookmark.setManga(mangaRepository.getMangaById(mangaId));
        bookmark.setStatus(bookmarkDTO.getStatus());
        if (bookmarkDTO.getRating() != null){
            bookmark.setRating(Math.round(bookmarkDTO.getRating() * 10.0) / 10.0);
        } else {
            bookmark.setRating(bookmarkDTO.getRating());
        }
        bookmark.setChapter(bookmarkDTO.getChapter());
        bookmark.setPage(bookmarkDTO.getPage());
        bookmark.setUser(userRepository.getUserById(userId));

        return bookmark;
    }

    public BookmarkDTO toDTO(final Bookmark bookmark) {
        final BookmarkDTO bookmarkDTO = new BookmarkDTO();

        bookmarkDTO.setManga(mangaMapper.toDTO(bookmark.getManga()));
        bookmarkDTO.setStatus(bookmark.getStatus());
        if (bookmark.getRating() != null){
            bookmarkDTO.setRating(Math.round(bookmark.getRating() * 10.0) / 10.0);
        } else {
            bookmarkDTO.setRating(bookmark.getRating());
        }
        bookmarkDTO.setChapter(bookmark.getChapter());
        bookmarkDTO.setPage(bookmark.getPage());

        return bookmarkDTO;
    }

}
