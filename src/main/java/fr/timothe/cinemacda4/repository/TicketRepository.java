package fr.timothe.cinemacda4.repository;

import fr.timothe.cinemacda4.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
