package fr.timothe.cinemacda4.service;

import fr.timothe.cinemacda4.entity.Seance;
import fr.timothe.cinemacda4.entity.Ticket;
import fr.timothe.cinemacda4.repository.SeanceRepository;
import fr.timothe.cinemacda4.repository.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.imageio.spi.ServiceRegistry;
import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final SeanceRepository seanceRepository;
    private final SeanceService seanceService;

    public TicketService(TicketRepository ticketRepository, SeanceRepository seanceRepository, SeanceService seanceService) {
        this.ticketRepository = ticketRepository;
        this.seanceRepository = seanceRepository;
        this.seanceService = seanceService;
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

    // Code à reformater
    public Ticket save(Ticket ticket) {
        if (ticket.getNomClient().isEmpty()) {
            throw new IllegalArgumentException(
                    "Veuillez ajouter un nom pour le ticket"
            );
        }

        if (ticket.getNombrePlaces() <= 0) {
            throw new IllegalArgumentException(
                    "Le nombre de place doit être supérieur à 0"
            );
        }

        Seance seance = this.seanceService.findById(ticket.getSeance().getId());

        if (seance.getPlacesDisponibles() - ticket.getNombrePlaces() < 0) {
            throw new IllegalArgumentException(
                    "Il ne reste que " + seance.getPlacesDisponibles() + " places disponibles pour cette séance"
            );
        }

        seance.setPlacesDisponibles(seance.getPlacesDisponibles() - ticket.getNombrePlaces());
        this.seanceRepository.save(seance);
        this.ticketRepository.save(ticket);
        return ticket;
    }

    public Ticket update(Ticket ticket, Integer id) {
        this.seanceService.findById(ticket.getSeance().getId());
        this.findById(id);
        ticket.setId(id);
        return this.save(ticket);
    }

    public void delete(Integer id) {
        Ticket ticket = this.findById(id);
        this.ticketRepository.delete(ticket);
    }
}
