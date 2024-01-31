package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Realisateur;
import fr.timothe.cinemacda4.repository.RealisateurRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Realisateur findById(Integer id) {
        return this.realisateurRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Aucun réalisateur pour l'id : " + id
                )
        );
    }

    public Realisateur save(Realisateur realisateur) {
        this.realisateurRepository.save(realisateur);
        return realisateur;
    }

    public Realisateur update(Realisateur realisateur, Integer id) {
        this.findById(id);
        realisateur.setId(id);
        this.realisateurRepository.save(realisateur);
        return realisateur;
    }

    // A TESTER
    public void delete(Integer id) {
        Realisateur realisateur = this.findById(id);
        this.realisateurRepository.delete(realisateur);
    }
}
