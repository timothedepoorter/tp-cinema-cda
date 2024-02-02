package fr.timothe.cinemacda4.controller;

import fr.timothe.cinemacda4.entity.Ticket;
import fr.timothe.cinemacda4.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket save(@RequestBody Ticket ticket) {
        return this.ticketService.save(ticket);
    }
}
