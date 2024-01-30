package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Realisateur;
import fr.timothe.cinemacda4.repository.RealisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealisateurService {
    private final RealisateurRepository realisateurRepository;

    public RealisateurService(RealisateurRepository realisateurRepository) {
        this.realisateurRepository = realisateurRepository;
    }

    public List<Realisateur> findAll() {
        return this.realisateurRepository.findAll();
    }
}
