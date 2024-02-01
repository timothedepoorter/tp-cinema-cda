package fr.timothe.cinemacda4.controller;

import fr.timothe.cinemacda4.entity.Salle;
import fr.timothe.cinemacda4.service.SalleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/salles")
public class SalleController {
    private final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Salle> findAll() {
        return this.salleService.findAll();
    }
}
