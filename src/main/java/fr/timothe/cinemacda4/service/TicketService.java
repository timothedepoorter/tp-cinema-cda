package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Ticket;
import fr.timothe.cinemacda4.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> findAll() {
        return this.ticketRepository.findAll();
    }
}
