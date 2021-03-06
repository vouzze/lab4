package com.lpnu.resource;

import com.lpnu.model.MangaDTO;
import com.lpnu.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MangaResource {
    @Autowired
    private MangaService mangaService;

    @GetMapping("/mangas/{id}")
    public MangaDTO getMangaById(final @PathVariable Long id){
        return mangaService.getMangaById(id);
    }

    @GetMapping("/mangas")
    public List<MangaDTO> getAllMangas(){
        return mangaService.getAllMangas();
    }

    @PostMapping("/mangas")
    public MangaDTO createManga(final @Valid @RequestBody MangaDTO mangaDTO){
        return mangaService.createManga(mangaDTO);
    }

    @PutMapping("/mangas")
    public MangaDTO updateManga(final @Valid @RequestBody MangaDTO mangaDTO){
        return mangaService.updateManga(mangaDTO);
    }

    @DeleteMapping("/mangas/{id}")
    public void deleteMangaById(final @PathVariable Long id){
        mangaService.deleteMangaById(id);
    }
}
