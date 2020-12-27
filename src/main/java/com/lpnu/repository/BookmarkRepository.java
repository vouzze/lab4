package com.lpnu.repository;

import com.lpnu.entity.Bookmark;
import com.lpnu.exception.ServiceException;
import com.lpnu.model.enumeration.Status;
import com.lpnu.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class BookmarkRepository {
    @PostConstruct
    public void init() {
        savedBookmarks = new ArrayList<>();
    }

    private List<Bookmark> savedBookmarks;

    public Bookmark getBookmarkByMangaAndUserId(final Long userId, final Long mangaId) {
        return savedBookmarks.stream()
                .filter(e -> e.getUser().getId().equals(userId) && e.getManga().getId().equals(mangaId))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Bookmark with user id and manga id: " + userId
                        + " and " + mangaId + " not found ", null));
    }

    public List<Bookmark> getBookmarksByUserId(final Long userId) {
        return savedBookmarks.stream()
                .filter(e -> e.getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<Bookmark> getWantToReadBookmarksByUserId(final Long userId) {
        return savedBookmarks.stream()
                .filter(e -> e.getUser().getId().equals(userId))
                .filter(e -> e.getStatus().equals(Status.WANT_TO_READ.toString()))
                .collect(Collectors.toList());
    }

    public List<Bookmark> getNowReadingBookmarksByUserId(final Long userId) {
        return savedBookmarks.stream()
                .filter(e -> e.getUser().getId().equals(userId))
                .filter(e -> e.getStatus().equals(Status.NOW_READING.toString()))
                .collect(Collectors.toList());
    }

    public List<Bookmark> getAlreadyReadBookmarksByUserId(final Long userId) {
        return savedBookmarks.stream()
                .filter(e -> e.getUser().getId().equals(userId))
                .filter(e -> e.getStatus().equals(Status.ALREADY_READ.toString()))
                .collect(Collectors.toList());
    }

    public List<Bookmark> getBookmarksByMangaId(final Long mangaId) {
        return savedBookmarks.stream()
                .filter(e -> e.getManga().getId().equals(mangaId))
                .collect(Collectors.toList());
    }

    public List<Bookmark> getWantToReadBookmarksByMangaId(final Long mangaId) {
        return savedBookmarks.stream()
                .filter(e -> e.getManga().getId().equals(mangaId))
                .filter(e -> e.getStatus().equals(Status.WANT_TO_READ.toString()))
                .collect(Collectors.toList());
    }

    public List<Bookmark> getNowReadingBookmarksByMangaId(final Long mangaId) {
        return savedBookmarks.stream()
                .filter(e -> e.getManga().getId().equals(mangaId))
                .filter(e -> e.getStatus().equals(Status.NOW_READING.toString()))
                .collect(Collectors.toList());
    }

    public List<Bookmark> getAlreadyReadBookmarksByMangaId(final Long mangaId) {
        return savedBookmarks.stream()
                .filter(e -> e.getManga().getId().equals(mangaId))
                .filter(e -> e.getStatus().equals(Status.ALREADY_READ.toString()))
                .collect(Collectors.toList());
    }

    public List<Bookmark> getAllBookmarks() {
        return savedBookmarks;
    }

    public List<Bookmark> getAllWantToReadBookmarks() {
        return savedBookmarks.stream()
                .filter(e -> e.getStatus().equals(Status.WANT_TO_READ.toString()))
                .collect(Collectors.toList());
    }

    public List<Bookmark> getAllNowReadingBookmarks() {
        return savedBookmarks.stream()
                .filter(e -> e.getStatus().equals(Status.NOW_READING.toString()))
                .collect(Collectors.toList());
    }

    public List<Bookmark> getAllAlreadyReadBookmarks() {
        return savedBookmarks.stream()
                .filter(e -> e.getStatus().equals(Status.ALREADY_READ.toString()))
                .collect(Collectors.toList());
    }

    public Bookmark createBookmark(final Bookmark bookmark) {
        if (bookmark.getUser().getId() == null) {
            throw new ServiceException(400, "Bookmark should have user id ", null);
        } else if (bookmark.getManga().getId() == null) {
            throw new ServiceException(400, "Bookmark should have manga id ", null);
        } else if (savedBookmarks.stream()
                .filter(e -> e.getUser().getId().equals(bookmark.getUser().getId())
                        && e.getManga().getId().equals(bookmark.getManga().getId()))
                .findFirst().orElse(null) != null) {
            throw new ServiceException(400, "Bookmark already exists ", null);
        }

        if (bookmark.getRating() != null && bookmark.getChapter() != null) {
            throw new ServiceException(400, "Bookmark should have either rating or chapter ", null);
        } else if (bookmark.getRating() != null && bookmark.getPage() != null) {
            throw new ServiceException(400, "Bookmark should have either rating or page ", null);
        } else if (bookmark.getChapter() != null && bookmark.getPage() == null) {
            throw new ServiceException(400, "If bookmark has chapter, it should have page as well ", null);
        } else if (bookmark.getChapter() == null && bookmark.getPage() != null) {
            throw new ServiceException(400, "If bookmark has page, it should have chapter as well ", null);
        } else if (bookmark.getChapter() != null &&
                (bookmark.getChapter() > Collections.max(bookmark.getManga().getChapters().keySet()))) {
            throw new ServiceException(400, "Bookmark chapter is greater than manga last chapter ", null);
        } else if (bookmark.getPage() != null &&
                (bookmark.getPage() > bookmark.getManga().getChapters().get(bookmark.getChapter()))) {
            throw new ServiceException(400, "Bookmark page is greater than manga chapter's last page ", null);
        }

        if (bookmark.getRating() != null) {
            bookmark.setStatus(Status.ALREADY_READ.toString());
        } else if (bookmark.getChapter() != null && bookmark.getPage() != null) {
            bookmark.setStatus(Status.NOW_READING.toString());
        } else {
            bookmark.setStatus(Status.WANT_TO_READ.toString());
        }

        savedBookmarks.add(bookmark);

        if (bookmark.getUser().getBookmarks() != null) {
            bookmark.getUser().getBookmarks().add(bookmark);
        } else {
            bookmark.getUser().setBookmarks(new ArrayList<>(Collections.singletonList(bookmark)));
        }


        return bookmark;
    }

    public Bookmark updateBookmark(final Bookmark bookmark) {
        if (bookmark.getUser().getId() == null) {
            throw new ServiceException(400, "Bookmark should have user id ", null);
        } else if (bookmark.getManga().getId() == null) {
            throw new ServiceException(400, "Bookmark should have manga id ", null);
        }

        final Bookmark savedBookmark = getBookmarkByMangaAndUserId(bookmark.getManga().getId(), bookmark.getUser().getId());

        if (bookmark.getChapter() != null && bookmark.getPage() == null) {
            throw new ServiceException(400, "If bookmark has chapter, it should have page as well ", null);
        } else if (bookmark.getChapter() == null && bookmark.getPage() != null) {
            throw new ServiceException(400, "If bookmark has page, it should have chapter as well ", null);
        } else if (bookmark.getChapter() != null &&
                (bookmark.getChapter() > Collections.max(bookmark.getManga().getChapters().keySet()))) {
            throw new ServiceException(400, "Bookmark chapter is greater than manga last chapter ", null);
        } else if (bookmark.getPage() != null &&
                (bookmark.getPage() > bookmark.getManga().getChapters().get(bookmark.getChapter()))) {
            throw new ServiceException(400, "Bookmark page is greater than manga chapter's last page ", null);
        }

        if (bookmark.getRating() != null) {
            savedBookmark.setManga(bookmark.getManga());
            savedBookmark.setStatus(Status.ALREADY_READ.toString());
            savedBookmark.setRating(Util.round(bookmark.getRating()));
            savedBookmark.setChapter(null);
            savedBookmark.setPage(null);
            savedBookmark.setUser(bookmark.getUser());
        } else if (bookmark.getChapter() != null && bookmark.getPage() != null) {
            savedBookmark.setManga(bookmark.getManga());
            savedBookmark.setStatus(Status.NOW_READING.toString());
            savedBookmark.setChapter(bookmark.getChapter());
            savedBookmark.setPage(bookmark.getPage());
            savedBookmark.setUser(bookmark.getUser());
        } else {
            savedBookmark.setManga(bookmark.getManga());
            savedBookmark.setStatus(Status.WANT_TO_READ.toString());
            savedBookmark.setRating(null);
            savedBookmark.setChapter(null);
            savedBookmark.setPage(null);
            savedBookmark.setUser(bookmark.getUser());
        }

        return savedBookmark;
    }

    public void deleteBookmarkByMangaAndUserId(final Long userId, final Long mangaId) {
        if (userId == null) {
            throw new ServiceException(400, "Bookmark should have user id ", null);
        } else if (mangaId == null) {
            throw new ServiceException(400, "Bookmark should have manga id ", null);
        }

        savedBookmarks.stream()
                .filter(e -> e.getUser().getId().equals(userId) && e.getManga().getId().equals(mangaId))
                .peek(e -> e.getUser().setBookmarks(e.getUser().getBookmarks().stream()
                        .filter(b -> !b.getManga().getId().equals(mangaId))
                        .collect(Collectors.toList())))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Bookmark with user id and manga id: " + userId
                        + " and " + mangaId + " not found ", null));

        savedBookmarks = savedBookmarks.stream()
                .filter(e -> !(e.getUser().getId().equals(userId) && e.getManga().getId().equals(mangaId)))
                .collect(Collectors.toList());

    }

    public void deleteBookmarksByUserId(final Long userId) {
        if (userId == null) {
            throw new ServiceException(400, "Bookmarks should have user id ", null);
        }

        savedBookmarks.stream()
                .filter(e -> e.getUser().getId().equals(userId))
                .peek(e -> e.getUser().setBookmarks(null))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Bookmarks with user id: " +
                        userId + " not found ", null));

        savedBookmarks = savedBookmarks.stream()
                .filter(e -> !(e.getUser().getId().equals(userId)))
                .collect(Collectors.toList());
    }

    public void deleteBookmarksByMangaId(final Long mangaId) {
        if (mangaId == null) {
            throw new ServiceException(400, "Bookmarks should have manga id ", null);
        }

        savedBookmarks.stream()
                .filter(e -> e.getManga().getId().equals(mangaId))
                .peek(e -> e.getUser().setBookmarks(e.getUser().getBookmarks().stream()
                        .filter(b -> !b.getManga().getId().equals(mangaId))
                        .collect(Collectors.toList())))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Bookmarks with manga id: " +
                        mangaId + " not found ", null));


        savedBookmarks = savedBookmarks.stream()
                .filter(e -> !(e.getManga().getId().equals(mangaId)))
                .collect(Collectors.toList());
    }
}
