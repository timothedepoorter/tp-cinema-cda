package fr.timothe.cinemacda4.controller;

import fr.timothe.cinemacda4.entity.Acteur;
import fr.timothe.cinemacda4.service.ActeurService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {
    private final ActeurService acteurService;

    public ActeurController(ActeurService acteurService) {
        this.acteurService = acteurService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Acteur> findAll() {
        return this.acteurService.findAll();
    }
}
