package fr.timothe.cinemacda4.controller;

import fr.timothe.cinemacda4.dto.RealisateurAvecFilmsDto;
import fr.timothe.cinemacda4.entity.Realisateur;
import fr.timothe.cinemacda4.service.RealisateurService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/realisateurs")
public class RealisateurController {
    private final RealisateurService realisateurService;

    public RealisateurController(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Realisateur> findAll() {
        return this.realisateurService.findAll();
    }

    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RealisateurAvecFilmsDto findById(@PathVariable int id) {
        return realisateurService.findRealisateurWithFilm(id);
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
