package fr.timothe.cinemacda4.controller;

import fr.timothe.cinemacda4.entity.Seance;
import fr.timothe.cinemacda4.service.SeanceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping(path = "/seances")
public class SeanceController {
    private final SeanceService seanceService;

    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Seance> findAll() {
        return this.seanceService.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Seance findById(@PathVariable Integer id) {
        return this.seanceService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Seance save(@RequestBody Seance seance) {
        return this.seanceService.save(seance);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Seance update(@RequestBody Seance seance, @PathVariable Integer id) {
        return this.seanceService.update(seance, id);
    }
}
