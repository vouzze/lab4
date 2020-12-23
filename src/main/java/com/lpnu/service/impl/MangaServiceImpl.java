package com.lpnu.service.impl;

import com.lpnu.dto.MangaDTO;
import com.lpnu.mapper.MangaToMangaDTOMapper;
import com.lpnu.repository.MangaRepository;
import com.lpnu.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MangaServiceImpl implements MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    @Autowired
    private MangaToMangaDTOMapper mangaToMangaDTOMapper;

    @Override
    public MangaDTO getMangaById(final Long id) {
        return mangaToMangaDTOMapper.toDTO(mangaRepository.getDummyManga());
    }

    @Override
    public List<MangaDTO> getAllMangas() {
        return Collections.singletonList(mangaToMangaDTOMapper.toDTO(mangaRepository.getDummyManga()));
    }

    @Override
    public MangaDTO createManga(final MangaDTO mangaDTO) {
        return null;
    }

    @Override
    public MangaDTO updateManga(final MangaDTO mangaDTO) {
        return null;
    }

    @Override
    public void deleteMangaById(final Long id) {

    }
}
