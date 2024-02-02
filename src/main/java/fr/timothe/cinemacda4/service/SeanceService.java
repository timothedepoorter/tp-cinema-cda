package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Seance;
import fr.timothe.cinemacda4.repository.SalleRepository;
import fr.timothe.cinemacda4.repository.SeanceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SeanceService {
    private final SeanceRepository seanceRepository;
    private final SalleRepository salleRepository;
    private final SalleService salleService;

    public SeanceService(SeanceRepository seanceRepository, SalleRepository salleRepository, SalleService salleService) {
        this.seanceRepository = seanceRepository;
        this.salleRepository = salleRepository;
        this.salleService = salleService;
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
        salleService.findById(seance.getSalle().getId());
        this.seanceRepository.save(seance);
        return seance;
    }

    public Seance update(Seance seance, Integer id) {
        salleService.findById(seance.getSalle().getId());
        this.findById(id);
        seance.setId(id);
        return this.save(seance);
    }

    public void delete(Integer id) {
        Seance seance = this.findById(id);
        this.seanceRepository.delete(seance);
    }
}
