package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Film;
import fr.timothe.cinemacda4.entity.Realisateur;
import fr.timothe.cinemacda4.repository.RealisateurRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RealisateurService {
    private final RealisateurRepository realisateurRepository;
    private final FilmService filmService;

    public RealisateurService(RealisateurRepository realisateurRepository, FilmService filmService) {
        this.realisateurRepository = realisateurRepository;
        this.filmService = filmService;
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
        List<Film> filmsAvecCeRealisateur = filmService.findAllByRealisateurId(id);
        filmsAvecCeRealisateur.forEach(
                (film) -> {
                    film.setRealisateur(null);
                    filmService.save(film);
                }
        );
        this.realisateurRepository.delete(realisateur);
    }
}
