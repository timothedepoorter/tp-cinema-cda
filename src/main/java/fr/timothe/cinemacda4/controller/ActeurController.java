package fr.timothe.cinemacda4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.timothe.cinemacda4.dto.ActeurDto;
import fr.timothe.cinemacda4.dto.ActeurWithFilmsDto;
import fr.timothe.cinemacda4.entity.Acteur;
import fr.timothe.cinemacda4.service.ActeurService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {
    private final ActeurService acteurService;
    private final ObjectMapper objectMapper;
    public ActeurController(ActeurService acteurService, ObjectMapper objectMapper) {
        this.acteurService = acteurService;
        this.objectMapper = objectMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActeurDto> findAll() {
        return this.acteurService.findAll().stream().map(
                acteur -> objectMapper.convertValue(acteur, ActeurDto.class)
        ).toList();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActeurWithFilmsDto findById(@PathVariable Integer id) {
        return objectMapper.convertValue(this.acteurService.findById(id), ActeurWithFilmsDto.class);
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
