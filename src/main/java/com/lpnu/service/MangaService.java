package com.lpnu.service;



import com.lpnu.model.MangaDTO;

import java.util.List;

public interface MangaService {
    MangaDTO getMangaById(Long id);
    List<MangaDTO> getAllMangas();
    MangaDTO createManga(MangaDTO mangaDTO);
    MangaDTO updateManga(MangaDTO mangaDTO);
    void deleteMangaById(Long id);
}

