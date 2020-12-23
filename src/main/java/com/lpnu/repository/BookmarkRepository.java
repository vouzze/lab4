package com.lpnu.repository;

import com.lpnu.entity.Bookmark;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class BookmarkRepository {
    @PostConstruct
    public void init(){
        dummyBookmark = new Bookmark();
    }

    private Bookmark dummyBookmark;


    public List<Bookmark> getBookmarksByMangaAndUserId(final Long mangaId, final Long userId){
        return null;
    }
}
