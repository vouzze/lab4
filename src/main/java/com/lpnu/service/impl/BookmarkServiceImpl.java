package com.lpnu.service.impl;

import com.lpnu.model.BookmarkDTO;
import com.lpnu.exception.ServiceException;
import com.lpnu.mapper.BookmarkToBookmarkDTOMapper;
import com.lpnu.repository.BookmarkRepository;
import com.lpnu.repository.UserRepository;
import com.lpnu.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookmarkToBookmarkDTOMapper bookmarkMapper;

    @Override
    public BookmarkDTO getBookmarkByMangaAndUserId(final Long userId, final Long mangaId) {
        return bookmarkMapper.toDTO(bookmarkRepository.getBookmarkByMangaAndUserId(userId, mangaId));
    }

    @Override
    public List<BookmarkDTO> getBookmarksByUserId(final Long userId) {
        return bookmarkRepository.getBookmarksByUserId(userId).stream()
                .map(e -> bookmarkMapper.toDTO(e))
                .collect(Collectors.toList());
    }
    @Override
    public List<BookmarkDTO> getWantToReadBookmarksByUserId(final Long userId) {
        return bookmarkRepository.getWantToReadBookmarksByUserId(userId).stream()
                .map(e -> bookmarkMapper.toDTO(e))
                .collect(Collectors.toList());
    }
    @Override
    public List<BookmarkDTO> getNowReadingBookmarksByUserId(final Long userId) {
        return bookmarkRepository.getNowReadingBookmarksByUserId(userId).stream()
                .map(e -> bookmarkMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookmarkDTO> getAlreadyReadBookmarksByUserId(final Long userId) {
        return bookmarkRepository.getAlreadyReadBookmarksByUserId(userId).stream()
                .map(e -> bookmarkMapper.toDTO(e))
                .collect(Collectors.toList());
    }
    @Override
    public List<BookmarkDTO> getBookmarksByMangaId(final Long mangaId) {
        return bookmarkRepository.getBookmarksByMangaId(mangaId).stream()
                .map(e -> bookmarkMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookmarkDTO> getWantToReadBookmarksByMangaId(final Long mangaId) {
        return bookmarkRepository.getWantToReadBookmarksByMangaId(mangaId).stream()
                .map(e -> bookmarkMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookmarkDTO> getNowReadingBookmarksByMangaId(final Long mangaId) {
        return bookmarkRepository.getNowReadingBookmarksByMangaId(mangaId).stream()
                .map(e -> bookmarkMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookmarkDTO> getAlreadyReadBookmarksByMangaId(final Long mangaId) {
        return bookmarkRepository.getAlreadyReadBookmarksByMangaId(mangaId).stream()
                .map(e -> bookmarkMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookmarkDTO> getAllBookmarks() {
        return bookmarkRepository.getAllBookmarks().stream()
                .map(e -> bookmarkMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookmarkDTO> getAllWantToReadBookmarks() {
        return bookmarkRepository.getAllWantToReadBookmarks().stream()
                .map(e -> bookmarkMapper.toDTO(e))
                .collect(Collectors.toList());
    }
    @Override
    public List<BookmarkDTO> getAllNowReadingBookmarks() {
        return bookmarkRepository.getAllNowReadingBookmarks().stream()
                .map(e -> bookmarkMapper.toDTO(e))
                .collect(Collectors.toList());
    }
    @Override
    public List<BookmarkDTO> getAllAlreadyReadBookmarks() {
        return bookmarkRepository.getAllAlreadyReadBookmarks().stream()
                .map(e -> bookmarkMapper.toDTO(e))
                .collect(Collectors.toList());
    }
    @Override
    public BookmarkDTO createBookmark(final BookmarkDTO bookmarkDTO, final Long userId, final Long mangaId) {
        if(userId == null){
            throw new ServiceException(400, "Bookmark should have user id ", null);
        } else if (mangaId == null) {
            throw new ServiceException(400, "Bookmark should have manga id ", null);
        }

        return bookmarkMapper.toDTO(bookmarkRepository.createBookmark(bookmarkMapper.toEntity(bookmarkDTO, userId,
                mangaId)));
    }

    @Override
    public BookmarkDTO updateBookmark(final BookmarkDTO bookmarkDTO, final Long userId, final Long mangaId) {
        if(userId == null){
            throw new ServiceException(400, "Bookmark should have user id ", null);
        } else if (mangaId == null) {
            throw new ServiceException(400, "Bookmark should have manga id ", null);
        }

        return bookmarkMapper.toDTO(bookmarkRepository.updateBookmark(bookmarkMapper.toEntity(bookmarkDTO, userId,
                mangaId)));
    }

    @Override
    public void deleteBookmarkByMangaAndUserId(final Long userId, final Long mangaId) {
        if(userId == null){
            throw new ServiceException(400, "Bookmark should have user id ", null);
        } else if (mangaId == null) {
            throw new ServiceException(400, "Bookmark should have manga id ", null);
        }

        bookmarkRepository.deleteBookmarkByMangaAndUserId(userId, mangaId);
    }

    @Override
    public void deleteBookmarksByUserId(final Long userId) {
        if(userId == null) {
            throw new ServiceException(400, "Bookmark should have user id ", null);
        }

        bookmarkRepository.deleteBookmarksByUserId(userId);
    }

    @Override
    public void deleteBookmarksByMangaId(final Long mangaId) {
        if(mangaId == null) {
            throw new ServiceException(400, "Bookmark should have manga id ", null);
        }

        bookmarkRepository.deleteBookmarksByMangaId(mangaId);
    }
}
