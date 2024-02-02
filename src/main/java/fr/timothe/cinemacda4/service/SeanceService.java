package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Seance;
import fr.timothe.cinemacda4.repository.SeanceRepository;
import org.springframework.stereotype.Service;

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
}
