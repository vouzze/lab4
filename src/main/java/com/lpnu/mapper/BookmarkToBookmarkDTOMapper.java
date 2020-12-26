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
        }
        final Bookmark bookmark = new Bookmark();

        bookmark.setManga(mangaRepository.getMangaById(mangaId));
        bookmark.setStatus(bookmarkDTO.getStatus());
        bookmark.setRating(bookmarkDTO.getRating());
        bookmark.setChapter(bookmarkDTO.getChapter());
        bookmark.setPage(bookmarkDTO.getPage());
        bookmark.setUser(userRepository.getUserById(userId));

        return bookmark;
    }

    public BookmarkDTO toDTO(final Bookmark bookmark) {
        final BookmarkDTO bookmarkDTO = new BookmarkDTO();

        bookmarkDTO.setManga(mangaMapper.toDTO(bookmark.getManga()));
        bookmarkDTO.setStatus(bookmark.getStatus());
        bookmarkDTO.setRating(bookmark.getRating());
        bookmarkDTO.setChapter(bookmark.getChapter());
        bookmarkDTO.setPage(bookmark.getPage());

        return bookmarkDTO;
    }

}
