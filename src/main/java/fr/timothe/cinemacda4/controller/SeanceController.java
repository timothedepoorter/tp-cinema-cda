package fr.timothe.cinemacda4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.timothe.cinemacda4.dto.SeanceDto.SeanceIdDatePrixPlacesDisposSalleDto;
import fr.timothe.cinemacda4.entity.Seance;
import fr.timothe.cinemacda4.service.SeanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping(path = "/seances")
public class SeanceController {
    private final SeanceService seanceService;
    private final ObjectMapper objectMapper;

    public SeanceController(SeanceService seanceService, ObjectMapper objectMapper) {
        this.seanceService = seanceService;
        this.objectMapper = objectMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SeanceIdDatePrixPlacesDisposSalleDto> findAll() {
        List<Seance> seances = this.seanceService.findAll();
        return seances.stream().map(
                seance -> objectMapper.convertValue(
                        seance,
                        SeanceIdDatePrixPlacesDisposSalleDto.class
                )
        ).toList();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SeanceIdDatePrixPlacesDisposSalleDto findById(@PathVariable Integer id) {
        return objectMapper.convertValue(
                this.seanceService.findById(id),
                SeanceIdDatePrixPlacesDisposSalleDto.class
        );
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public SeanceIdDatePrixPlacesDisposSalleDto save(@RequestBody Seance seance) {
        return objectMapper.convertValue(
                this.seanceService.save(seance),
                SeanceIdDatePrixPlacesDisposSalleDto.class
        );
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SeanceIdDatePrixPlacesDisposSalleDto update(@RequestBody Seance seance, @PathVariable Integer id) {
        return objectMapper.convertValue(
                this.seanceService.update(seance, id),
                SeanceIdDatePrixPlacesDisposSalleDto.class
        );
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.seanceService.delete(id);
    }
}
