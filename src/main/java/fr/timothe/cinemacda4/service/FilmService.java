package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Acteur;
import fr.timothe.cinemacda4.entity.Film;
import fr.timothe.cinemacda4.exception.FilmNotFoundException;
import fr.timothe.cinemacda4.repository.ActeurRepository;
import fr.timothe.cinemacda4.repository.FilmRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    private final FilmRepository filmRepository;
    private final ActeurService acteurService;
    public FilmService(FilmRepository filmRepository, ActeurService acteurService) {
        this.filmRepository = filmRepository;
        this.acteurService = acteurService;
    }

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    public Film save(Film film) {
        filmRepository.save(film);
        return film;
    }

    public Film findById(Integer id) {
        return filmRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Film " + id + " non trouvé"
                )
        );
    }

    public void deleteById(Integer id) {
        Film film = this.findById(id);
        filmRepository.delete(film);
    }

    public Film update(Film film) {
        return filmRepository.save(film);
    }

    public Film findByTitre(String titre) {
        return filmRepository.findByTitre(titre).orElseThrow(
                FilmNotFoundException::new
        );
    }

    public List<Film> findAllByRealisateurId(Integer id) {
        return filmRepository.findAllByRealisateurId(id).orElseThrow(
                FilmNotFoundException::new
        );
    }

    public void saveActeurToFilm(Acteur acteur, Integer id) {
        this.acteurService.findById(acteur.getId());
        Film film = this.findById(id);
        List<Acteur> listeActeur = film.getActeurs();
        listeActeur.add(acteur);
        film.setActeurs(listeActeur);
        this.save(film);
    }











}
