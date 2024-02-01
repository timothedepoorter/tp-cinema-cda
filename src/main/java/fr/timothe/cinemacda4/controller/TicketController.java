package fr.timothe.cinemacda4.controller;

import fr.timothe.cinemacda4.entity.Ticket;
import fr.timothe.cinemacda4.service.TicketService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ticket> findAll() {
        return this.ticketService.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ticket findById(@PathVariable Integer id) {
        return this.ticketService.findById(id);
    }
}
