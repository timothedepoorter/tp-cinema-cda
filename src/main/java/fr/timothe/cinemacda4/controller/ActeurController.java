package fr.timothe.cinemacda4.controller;

import fr.timothe.cinemacda4.entity.Acteur;
import fr.timothe.cinemacda4.service.ActeurService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Acteur findById(@PathVariable Integer id) {
        return this.acteurService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Acteur save(@RequestBody Acteur acteur) {
        this.acteurService.save(acteur);
        return acteur;
    }

    @PutMapping(path ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Acteur update(@RequestBody Acteur acteur, @PathVariable Integer id) {
        this.acteurService.update(acteur, id);
        return acteur;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.acteurService.delete(id);
    }
}
