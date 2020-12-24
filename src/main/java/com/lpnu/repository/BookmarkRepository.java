package com.lpnu.repository;

import com.lpnu.entity.Bookmark;
import com.lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookmarkRepository {
    @PostConstruct
    public void init(){
        savedBookmarks = new ArrayList<>();
    }

    private List<Bookmark> savedBookmarks;

    public Bookmark getBookmarkByMangaAndUserId(final Long mangaId, final Long userId){
        return savedBookmarks.stream()
                .filter(e -> e.getUser().getId().equals(userId) && e.getManga().getId().equals(mangaId))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Bookmark with manga id and user id: " + mangaId + " and " +
                        userId + " not found ", null));
    }

    public List<Bookmark> getBookmarksByUserId(final Long userId){
        return savedBookmarks.stream()
                .filter(e -> e.getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<Bookmark> getAllBookmarks(){
        return savedBookmarks;
    }

    public Bookmark createBookmark(final Bookmark bookmark){
        if(bookmark.getUser().getId() == null){
            throw new ServiceException(400, "Bookmark should have user id ", null);
        } else if (bookmark.getManga().getId() == null) {
            throw new ServiceException(400, "Bookmark should have manga id ", null);
        }

        if (bookmark.getRating() != null && bookmark.getChapter() != null) {
            throw new ServiceException(400, "Bookmark should have either rating or chapter ", null);
        } else if (bookmark.getRating() != null && bookmark.getPage() != null) {
            throw new ServiceException(400, "Bookmark should have either rating or page ", null);
        } else if (!(bookmark.getChapter() != null && bookmark.getPage() != null)) {
            throw new ServiceException(400, "If bookmark has chapter, it should have page as well ", null);
        }

        savedBookmarks.add(bookmark);

        return bookmark;
    }

    public Bookmark updateBookmark(final Bookmark bookmark){
        if(bookmark.getUser().getId() == null){
            throw new ServiceException(400, "Bookmark should have user id ", null);
        } else if (bookmark.getManga().getId() == null) {
            throw new ServiceException(400, "Bookmark should have manga id ", null);
        }

        final Bookmark savedBookmark = getBookmarkByMangaAndUserId(bookmark.getManga().getId(), bookmark.getUser().getId());

        if (bookmark.getRating() != null && bookmark.getChapter() != null) {
            throw new ServiceException(400, "Bookmark should have either rating or chapter ", null);
        } else if (bookmark.getRating() != null && bookmark.getPage() != null) {
            throw new ServiceException(400, "Bookmark should have either rating or page ", null);
        } else if (!(bookmark.getChapter() != null && bookmark.getPage() != null)) {
            throw new ServiceException(400, "If bookmark has chapter, it should have page as well ", null);
        }

        if (bookmark.getRating() != null) {
            savedBookmark.setManga(bookmark.getManga());
            savedBookmark.setStatus("already read");
            savedBookmark.setRating(bookmark.getRating());
            savedBookmark.setUser(bookmark.getUser());
        } else if (bookmark.getChapter() != null && bookmark.getPage() != null) {
            savedBookmark.setManga(bookmark.getManga());
            savedBookmark.setStatus("now reading");
            savedBookmark.setChapter(bookmark.getChapter());
            savedBookmark.setPage(bookmark.getPage());
            savedBookmark.setUser(bookmark.getUser());
        } else {
            savedBookmark.setManga(bookmark.getManga());
            savedBookmark.setStatus("want to read");
            savedBookmark.setUser(bookmark.getUser());
        }

        return savedBookmark;
    }

    public void deleteBookmarkByMangaAndUserId(final Long mangaId, final Long userId){
        if(userId == null){
            throw new ServiceException(400, "Bookmark should have user id ", null);
        } else if (mangaId == null) {
            throw new ServiceException(400, "Bookmark should have manga id ", null);
        }

        savedBookmarks.stream()
                .filter(e -> e.getUser().getId().equals(userId) && e.getManga().getId().equals(mangaId))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Bookmark with manga id and user id: " + mangaId + " and " +
                        userId + " not found ", null));

        savedBookmarks = savedBookmarks.stream()
                .filter(e -> !(e.getUser().getId().equals(userId) && e.getManga().getId().equals(mangaId)))
                .collect(Collectors.toList());

    }

    public void deleteBookmarkSByUserId(final Long userId) {
        if(userId == null){
            throw new ServiceException(400, "Bookmarks should have user id ", null);
        }

        savedBookmarks.stream()
                .filter(e -> e.getUser().getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Bookmarks with user id: " +
                        userId + " not found ", null));

        savedBookmarks = savedBookmarks.stream()
                .filter(e -> !(e.getUser().getId().equals(userId)))
                .collect(Collectors.toList());
    }
}
