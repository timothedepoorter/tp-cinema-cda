package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Seance;
import fr.timothe.cinemacda4.repository.SeanceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SeanceService {
    private final SeanceRepository seanceRepository;

    public SeanceService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
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
        this.seanceRepository.save(seance);
        return seance;
    }
}
