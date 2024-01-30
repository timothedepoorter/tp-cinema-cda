package fr.timothe.cinemacda4.repository;

import fr.timothe.cinemacda4.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    Optional<Film> findByTitre(String titre);
}
