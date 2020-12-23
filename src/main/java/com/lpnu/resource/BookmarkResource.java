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

    @GetMapping("/bookmarks")
    public List<BookmarkDTO> getAllBookmarks(){
        return bookmarkService.getAllBookmarks();
    }

    @PostMapping("/bookmarks")
    public BookmarkDTO createBookmark(final @RequestBody BookmarkDTO bookmarkDTO){
        return bookmarkService.createBookmark(bookmarkDTO);
    }

    @PutMapping("/bookmarks")
    public BookmarkDTO updateBookmark(final @RequestBody BookmarkDTO bookmarkDTO){
        return bookmarkService.updateBookmark(bookmarkDTO);
    }

    @DeleteMapping("/bookmarks/{mangaId}/{userId}")
    public void deleteOrderByMangaAndUserId(final @PathVariable Long mangaId, final @PathVariable Long userId){
        bookmarkService.deleteBookmarkByMangaAndUserId(mangaId, userId);
    }
}
