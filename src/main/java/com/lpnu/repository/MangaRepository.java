package com.lpnu.repository;

import com.lpnu.entity.Manga;
import org.springframework.stereotype.Repository;

@Repository
public class MangaRepository {
    public Manga getDummyManga(){
        return new Manga(1L, "some title", 5.0, "name");
    }
}
