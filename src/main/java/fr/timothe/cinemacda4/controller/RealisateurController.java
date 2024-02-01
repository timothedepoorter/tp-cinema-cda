package fr.timothe.cinemacda4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.timothe.cinemacda4.dto.FilmTitreDureeDateSortieDto;
import fr.timothe.cinemacda4.dto.RealisateurIdNomPrenomFilmsTitreDateSortieDto;
import fr.timothe.cinemacda4.entity.Film;
import fr.timothe.cinemacda4.entity.Realisateur;
import fr.timothe.cinemacda4.service.RealisateurService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/realisateurs")
public class RealisateurController {
    private final RealisateurService realisateurService;
    private final ObjectMapper objectMapper;

    public RealisateurController(RealisateurService realisateurService, ObjectMapper objectMapper) {
        this.realisateurService = realisateurService;
        this.objectMapper = objectMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Realisateur> findAll() {
        return this.realisateurService.findAll();
    }

    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RealisateurIdNomPrenomFilmsTitreDateSortieDto findById(@PathVariable int id) {
        return realisateurService.findRealisateurWithFilm(id);
    }

    @GetMapping(path ="/{id}/films", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FilmTitreDureeDateSortieDto> findFilmsByRealisateurId(@PathVariable Integer id) {
        List<Film> filmsDuRealisateur = realisateurService.findFilmsByRealisateurId(id);

        return filmsDuRealisateur.stream().map(
                film -> objectMapper.convertValue(film, FilmTitreDureeDateSortieDto.class)
        ).toList();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Realisateur save(@RequestBody Realisateur realisateur) {
        this.realisateurService.save(realisateur);
        return realisateur;
    }

    @PutMapping(path = "/{id}")
    public Realisateur update(@RequestBody Realisateur realisateur, @PathVariable Integer id) {
        this.realisateurService.update(realisateur, id);
        return realisateur;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.realisateurService.delete(id);
    }
}
