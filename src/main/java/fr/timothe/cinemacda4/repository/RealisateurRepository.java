package fr.timothe.cinemacda4.repository;

import fr.timothe.cinemacda4.entity.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RealisateurRepository extends JpaRepository<Realisateur, Integer> {
}
