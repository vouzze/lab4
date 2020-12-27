package com.lpnu.resource;

import com.lpnu.model.BookmarkDTO;
import com.lpnu.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookmarkResource {
    @Autowired
    private BookmarkService bookmarkService;

    @GetMapping("/bookmarks/{userId}/{mangaId}")
    public BookmarkDTO getBookmarkByMangaAndUserId(final @PathVariable Long userId, final @PathVariable Long mangaId) {
        return bookmarkService.getBookmarkByMangaAndUserId(userId, mangaId);
    }

    @GetMapping("/bookmarks/user/{userId}")
    public List<BookmarkDTO> getBookmarksByUserId(final @PathVariable Long userId) {
        return bookmarkService.getBookmarksByUserId(userId);
    }

    @GetMapping("/bookmarks/want-to-read/user/{userId}")
    public List<BookmarkDTO> getWantToReadBookmarksByUserId(final @PathVariable Long userId) {
        return bookmarkService.getWantToReadBookmarksByUserId(userId);
    }

    @GetMapping("/bookmarks/now-reading/user/{userId}")
    public List<BookmarkDTO> getNowReadingBookmarksByUserId(final @PathVariable Long userId) {
        return bookmarkService.getNowReadingBookmarksByUserId(userId);
    }

    @GetMapping("/bookmarks/already-read/user/{userId}")
    public List<BookmarkDTO> getAlreadyReadBookmarksByUserId(final @PathVariable Long userId) {
        return bookmarkService.getAlreadyReadBookmarksByUserId(userId);
    }
    @GetMapping("/bookmarks/manga/{mangaId}")
    public List<BookmarkDTO> getBookmarksByMangaId(final @PathVariable Long mangaId) {
        return bookmarkService.getBookmarksByMangaId(mangaId);
    }

    @GetMapping("/bookmarks/want-to-read/manga/{mangaId}")
    public List<BookmarkDTO> getWantToReadBookmarksByMangaId(final @PathVariable Long mangaId) {
        return bookmarkService.getWantToReadBookmarksByMangaId(mangaId);
    }

    @GetMapping("/bookmarks/now-reading/manga/{mangaId}")
    public List<BookmarkDTO> getNowReadingBookmarksByMangaId(final @PathVariable Long mangaId) {
        return bookmarkService.getNowReadingBookmarksByMangaId(mangaId);
    }

    @GetMapping("/bookmarks/already-read/manga/{mangaId}")
    public List<BookmarkDTO> getAlreadyReadBookmarksByMangaId(final @PathVariable Long mangaId) {
        return bookmarkService.getAlreadyReadBookmarksByMangaId(mangaId);
    }
    @GetMapping("/bookmarks")
    public List<BookmarkDTO> getAllBookmarks() {
        return bookmarkService.getAllBookmarks();
    }

    @GetMapping("/bookmarks/want-to-read")
    public List<BookmarkDTO> getAllWantToReadBookmarks() {
        return bookmarkService.getAllWantToReadBookmarks();
    }

    @GetMapping("/bookmarks/now-reading")
    public List<BookmarkDTO> getAllNowReadingBookmarks() {
        return bookmarkService.getAllNowReadingBookmarks();
    }

    @GetMapping("/bookmarks/already-read")
    public List<BookmarkDTO> getAllAlreadyReadBookmarks() {
        return bookmarkService.getAllAlreadyReadBookmarks();
    }

    @PostMapping("/bookmarks/{userId}/{mangaId}")
    public BookmarkDTO createBookmark(final @RequestBody BookmarkDTO bookmarkDTO,
                                      final @PathVariable Long userId, final @PathVariable Long mangaId) {
        return bookmarkService.createBookmark(bookmarkDTO, userId, mangaId);
    }

    @PutMapping("/bookmarks/{userId}/{mangaId}")
    public BookmarkDTO updateBookmark(final @RequestBody BookmarkDTO bookmarkDTO,
                                      final @PathVariable Long userId, final @PathVariable Long mangaId) {
        return bookmarkService.updateBookmark(bookmarkDTO, userId, mangaId);
    }

    @DeleteMapping("/bookmarks/{mangaId}/{userId}")
    public void deleteBookmarkByMangaAndUserId(final @PathVariable Long mangaId, final @PathVariable Long userId) {
        bookmarkService.deleteBookmarkByMangaAndUserId(mangaId, userId);
    }

    @DeleteMapping("/bookmarks/user/{userId}")
    public void deleteBookmarksByUserId(final @PathVariable Long userId) {
        bookmarkService.deleteBookmarksByUserId(userId);
    }

    @DeleteMapping("/bookmarks/manga/{mangaId}")
    public void deleteBookmarksByMangaId(final @PathVariable Long mangaId) {
        bookmarkService.deleteBookmarksByMangaId(mangaId);
    }
}
