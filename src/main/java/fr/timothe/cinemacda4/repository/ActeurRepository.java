package fr.timothe.cinemacda4.repository;

import fr.timothe.cinemacda4.entity.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ActeurRepository extends JpaRepository<Acteur, Integer> {
}
