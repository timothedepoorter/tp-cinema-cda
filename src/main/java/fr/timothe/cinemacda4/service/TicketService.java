package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Ticket;
import fr.timothe.cinemacda4.repository.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Ticket findById(Integer id) {
        return this.ticketRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Aucun ticket pour cet id : " + id
                )
        );
    }

    public Ticket save(Ticket ticket) {
        this.ticketRepository.save(ticket);
        return ticket;
    }

    public Ticket update(Ticket ticket, Integer id) {
        this.findById(id);
        ticket.setId(id);
        return this.save(ticket);
    }
}
