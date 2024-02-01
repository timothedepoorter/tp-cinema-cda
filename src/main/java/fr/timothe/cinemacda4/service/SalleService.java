package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.repository.SalleRepository;
import org.springframework.stereotype.Service;

@Service
public class SalleService {
    private final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }
}
