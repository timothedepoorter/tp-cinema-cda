package fr.timothe.cinemacda4.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.timothe.cinemacda4.dto.FilmTitreDateSortieDto;
import fr.timothe.cinemacda4.dto.RealisateurIdNomPrenomFilmsTitreDateSortieDto;
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
    private final ObjectMapper objectMapper;

    public RealisateurService(RealisateurRepository realisateurRepository, FilmService filmService, ObjectMapper objectMapper) {
        this.realisateurRepository = realisateurRepository;
        this.filmService = filmService;
        this.objectMapper = objectMapper;
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

    public RealisateurIdNomPrenomFilmsTitreDateSortieDto findRealisateurWithFilm(Integer id) {
        // On récupère le réalisateur demandé
        Realisateur realisateur = this.findById(id);
        // On récupère la liste des films de ce réal en faisant appel au serivce Films
        List<Film> filmsDuRealisateur = filmService.findAllByRealisateurId(id);

        // On créé une instance à partir de notre DTO
        RealisateurIdNomPrenomFilmsTitreDateSortieDto realisateurAvecFilmsDto = new RealisateurIdNomPrenomFilmsTitreDateSortieDto();

        // On récupère les valeurs du réalisateur et on les affecte
        // à notre objet
        realisateurAvecFilmsDto.setId(realisateur.getId());
        realisateurAvecFilmsDto.setNom(realisateur.getNom());
        realisateurAvecFilmsDto.setPrenom(realisateur.getPrenom());

        realisateurAvecFilmsDto.setFilms(
                // On convertit la liste de film en notre DTO FilmMini
                // pour ne pas avoir d'erreur de type
                filmsDuRealisateur.stream().map(
                        film -> objectMapper.convertValue(film, FilmTitreDateSortieDto.class)
                ).toList()
        );

        // Puis l'on retourne l'objet qu'on a fabriqué
        return realisateurAvecFilmsDto;
    }

    public List<Film> findFilmsByRealisateurId(Integer id) {
        return filmService.findAllByRealisateurId(id);
    }
}
