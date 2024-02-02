package fr.timothe.cinemacda4.controller;

import fr.timothe.cinemacda4.entity.Seance;
import fr.timothe.cinemacda4.service.SeanceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
