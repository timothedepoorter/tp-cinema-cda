package fr.timothe.cinemacda4.repository;

import fr.timothe.cinemacda4.entity.Acteur;
import fr.timothe.cinemacda4.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface FilmRepository extends JpaRepository<Film, Integer> {
    Optional<Film> findByTitre(String titre);

    Optional<List<Film>> findAllByRealisateurId(Integer id);
}
