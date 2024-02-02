package fr.timothe.cinemacda4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.timothe.cinemacda4.dto.SalleDto.SalleIdNumCapaciteDto;
import fr.timothe.cinemacda4.entity.Salle;
import fr.timothe.cinemacda4.service.SalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/salles")
public class SalleController {
    private final SalleService salleService;
    private final ObjectMapper objectMapper;

    public SalleController(SalleService salleService, ObjectMapper objectMapper) {
        this.salleService = salleService;
        this.objectMapper = objectMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SalleIdNumCapaciteDto> findAll() {
        List<Salle> salles = this.salleService.findAll();
        return salles.stream().map(
                salle -> objectMapper.convertValue(
                        salle,
                        SalleIdNumCapaciteDto.class)
        ).toList();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SalleIdNumCapaciteDto findById(@PathVariable Integer id) {
        return objectMapper.convertValue(
                this.salleService.findById(id),
                SalleIdNumCapaciteDto.class
        );
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public SalleIdNumCapaciteDto save(@RequestBody Salle salle) {
        return objectMapper.convertValue(
                this.salleService.save(salle),
                SalleIdNumCapaciteDto.class
        );
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.salleService.delete(id);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SalleIdNumCapaciteDto update(@RequestBody Salle salle, @PathVariable Integer id) {
        return objectMapper.convertValue(
                this.salleService.update(salle, id),
                SalleIdNumCapaciteDto.class
        );
    }
}
