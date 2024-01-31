package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Acteur;
import fr.timothe.cinemacda4.repository.ActeurRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActeurService {
    private final ActeurRepository acteurRepository;

    public ActeurService(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }

    public List<Acteur> findAll() {
        return this.acteurRepository.findAll();
    }

    public Acteur findById(Integer id) {
        return this.acteurRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Aucun acteur trouvé pour l'id : " + id
                )
        );
    }
}
