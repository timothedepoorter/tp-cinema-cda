package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Salle;
import fr.timothe.cinemacda4.repository.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleService {
    private final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public List<Salle> findAll() {
        return this.salleRepository.findAll();
    }
}
