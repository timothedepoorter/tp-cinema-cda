package fr.timothe.cinemacda4.repository;

import fr.timothe.cinemacda4.entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Integer> {
}
