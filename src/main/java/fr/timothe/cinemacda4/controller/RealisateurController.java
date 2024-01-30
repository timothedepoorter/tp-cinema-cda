package fr.timothe.cinemacda4.controller;

import fr.timothe.cinemacda4.entity.Realisateur;
import fr.timothe.cinemacda4.service.RealisateurService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Realisateur findById(@PathVariable Integer id) {
        return this.realisateurService.findById(id);
    }
}
