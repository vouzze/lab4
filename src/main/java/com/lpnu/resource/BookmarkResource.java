package com.lpnu.resource;

import com.lpnu.dto.BookmarkDTO;
import com.lpnu.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookmarkResource {
    @Autowired
    private BookmarkService bookmarkService;

    @GetMapping("/bookmarks/{mangaId}/{userId}")
    public BookmarkDTO getBookmarkByMangaAndUserId(final @PathVariable Long mangaId, final @PathVariable Long userId){
        return bookmarkService.getBookmarkByMangaAndUserId(mangaId, userId);
    }

    @GetMapping("/bookmarks/{userId}")
    public List<BookmarkDTO> getBookmarksByUserId(final Long userId) {
        return bookmarkService.getBookmarksByUserId(userId);
    }

    @GetMapping("/bookmarks")
    public List<BookmarkDTO> getAllBookmarks(){
        return bookmarkService.getAllBookmarks();
    }

    @PostMapping("/bookmarks/{userId}")
    public BookmarkDTO createBookmark(final @RequestBody BookmarkDTO bookmarkDTO, final @PathVariable Long userId){
        return bookmarkService.createBookmark(bookmarkDTO, userId);
    }

    @PutMapping("/bookmarks/{userId}")
    public BookmarkDTO updateBookmark(final @RequestBody BookmarkDTO bookmarkDTO, final @PathVariable Long userId){
        return bookmarkService.updateBookmark(bookmarkDTO, userId);
    }

    @DeleteMapping("/bookmarks/{mangaId}/{userId}")
    public void deleteOrderByMangaAndUserId(final @PathVariable Long mangaId, final @PathVariable Long userId){
        bookmarkService.deleteBookmarkByMangaAndUserId(mangaId, userId);
    }

    @DeleteMapping("/bookmarks/{userId}")
    public void deleteBookmarkSByUserId(final @PathVariable Long userId){
        bookmarkService.deleteBookmarkSByUserId(userId);
    }
}
