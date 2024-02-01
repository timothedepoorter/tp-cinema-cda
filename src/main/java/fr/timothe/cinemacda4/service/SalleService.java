package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Salle;
import fr.timothe.cinemacda4.repository.SalleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

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

    public Salle findById(Integer id) {
        return this.salleRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Aucune salle trouvée pour l'id : " + id
                )
        );
    }

    public void save(Salle salle) {
        this.salleRepository.save(salle);
    }

    public void delete(Integer id) {
        Salle salle = this.findById(id);
        this.salleRepository.delete(salle);
    }

    public void update(Salle salle, Integer id) {
        this.findById(id);
        salle.setId(id);
        this.salleRepository.save(salle);
    }
}
