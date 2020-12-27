package com.lpnu.service.impl;

import com.lpnu.dto.MangaDTO;
import com.lpnu.exception.ServiceException;
import com.lpnu.mapper.MangaToMangaDTOMapper;
import com.lpnu.repository.MangaRepository;
import com.lpnu.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MangaServiceImpl implements MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    @Autowired
    private MangaToMangaDTOMapper mangaMapper;

    @Override
    public MangaDTO getMangaById(final Long id) {
        return mangaMapper.toDTO(mangaRepository.getMangaById(id));
    }

    @Override
    public List<MangaDTO> getAllMangas() {
        return mangaRepository.getAllMangas().stream()
                .map(e -> mangaMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public MangaDTO createManga(final MangaDTO mangaDTO) {
        if(mangaDTO.getId() != null){
            throw new ServiceException(400, "Manga shouldn't have an id ", null);
        }

        return mangaMapper.toDTO(mangaRepository.createManga(mangaMapper.toEntity(mangaDTO)));
    }

    @Override
    public MangaDTO updateManga(final MangaDTO mangaDTO) {
        if(mangaDTO.getId() == null){
            throw new ServiceException(400, "Manga should have an id ", null);
        }

        return mangaMapper.toDTO(mangaRepository.updateManga(mangaMapper.toEntity(mangaDTO)));
    }

    @Override
    public void deleteMangaById(final Long id) {
        mangaRepository.deleteMangaById(id);
    }
}
