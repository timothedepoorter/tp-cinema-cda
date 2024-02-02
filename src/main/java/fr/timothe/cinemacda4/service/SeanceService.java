package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Salle;
import fr.timothe.cinemacda4.entity.Seance;
import fr.timothe.cinemacda4.repository.SeanceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SeanceService {
    private final SeanceRepository seanceRepository;
    private final SalleService salleService;
    private final FilmService filmService;

    public SeanceService(SeanceRepository seanceRepository, SalleService salleService, FilmService filmService) {
        this.seanceRepository = seanceRepository;
        this.salleService = salleService;
        this.filmService = filmService;
    }

    public List<Seance> findAll() {
        return this.seanceRepository.findAll();
    }

    public Seance findById(Integer id) {
        return this.seanceRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Aucune séance pour cet id : " + id
                )
        );
    }

    public Seance save(Seance seance) {
        Salle salle = salleService.findById(seance.getSalle().getId());
        filmService.findById(seance.getFilm().getId());
        seance.setPlacesDisponibles(salle.getCapacite());
        this.seanceRepository.save(seance);
        return seance;
    }

    public Seance update(Seance seance, Integer id) {
        Salle salle = salleService.findById(seance.getSalle().getId());
        filmService.findById(seance.getFilm().getId());
        this.findById(id);
        seance.setPlacesDisponibles(salle.getCapacite());
        seance.setId(id);
        return this.save(seance);
    }

    public void delete(Integer id) {
        Seance seance = this.findById(id);
        this.seanceRepository.delete(seance);
    }
}
