package fr.timothe.cinemacda4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.timothe.cinemacda4.dto.FilmActeursDto;
import fr.timothe.cinemacda4.dto.FilmIdTitreDateSortieDureeSynopsisRealisateurActeursDto;
import fr.timothe.cinemacda4.dto.FilmRealisateurDto;
import fr.timothe.cinemacda4.dto.FilmIdTitreDateSortieDureeSynopsisDto;
import fr.timothe.cinemacda4.entity.Acteur;
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
    public List<FilmIdTitreDateSortieDureeSynopsisDto> findAll() {
        return filmService.findAll().stream().map(
                film -> objectMapper.convertValue(film, FilmIdTitreDateSortieDureeSynopsisDto.class)
        ).toList();
    }

    @PostMapping
    public Film save(@RequestBody Film film) {
        return filmService.save(film);
    }

    @PostMapping(path = "/{id}/acteurs", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Acteur saveActeurToFilm(@RequestBody Acteur acteur, @PathVariable Integer id) {
        this.filmService.saveActeurToFilm(acteur, id);
        return acteur;
    }

    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmIdTitreDateSortieDureeSynopsisRealisateurActeursDto findById(@PathVariable Integer id) {
        Film film = filmService.findById(id);
        return objectMapper.convertValue(film, FilmIdTitreDateSortieDureeSynopsisRealisateurActeursDto.class);
    }

    @GetMapping(path ="/{id}/acteurs", produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmActeursDto findActeursByFilm(@PathVariable Integer id) {
        Film film = filmService.findById(id);
        return objectMapper.convertValue(film, FilmActeursDto.class);
    }

    @GetMapping(path ="/{id}/realisateur", produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmRealisateurDto findRealisateurByFilm(@PathVariable Integer id) {
        Film film = filmService.findById(id);
        return objectMapper.convertValue(film, FilmRealisateurDto.class);
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