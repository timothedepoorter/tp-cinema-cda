package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.repository.SeanceRepository;
import org.springframework.stereotype.Service;

@Service
public class SeanceService {
    private final SeanceRepository seanceRepository;

    public SeanceService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }
}
