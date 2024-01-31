package fr.timothe.cinemacda4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.timothe.cinemacda4.dto.FilmCompletDto;
import fr.timothe.cinemacda4.dto.FilmsReduitsDto;
import fr.timothe.cinemacda4.entity.Film;
import fr.timothe.cinemacda4.service.FilmService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
    private final FilmService filmService;
    private final ObjectMapper objectMapper;

    public FilmController(FilmService filmService, ObjectMapper objectMapper) {
        this.filmService = filmService;
        this.objectMapper = objectMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FilmsReduitsDto> findAll() {
        return filmService.findAll().stream().map(
                film -> objectMapper.convertValue(film, FilmsReduitsDto.class)
        ).toList();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Film save(@RequestBody Film film) {
        return filmService.save(film);
    }

    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmCompletDto findById(@PathVariable Integer id) {
        Film film = filmService.findById(id);
        return objectMapper.convertValue(film, FilmCompletDto.class);
    }

    @DeleteMapping(path ="/{id}")
    public void deleteById(@PathVariable Integer id) {
        filmService.deleteById(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Film update(@RequestBody Film film) {
        return filmService.update(film);
    }

    @GetMapping(path = "/search")
    public Film findByTitre(@RequestParam String titre) {
        return filmService.findByTitre(titre);
    }
}