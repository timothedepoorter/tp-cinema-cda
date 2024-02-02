package fr.timothe.cinemacda4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.timothe.cinemacda4.dto.TicketDto.TicketIdNomClientNbPlacesSeanceDto;
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
    private final ObjectMapper objectMapper;

    public TicketController(TicketService ticketService, ObjectMapper objectMapper) {
        this.ticketService = ticketService;
        this.objectMapper = objectMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TicketIdNomClientNbPlacesSeanceDto> findAll() {
        List<Ticket> tickets = this.ticketService.findAll();
        return tickets.stream().map(
                ticket -> objectMapper.convertValue(
                        ticket,
                        TicketIdNomClientNbPlacesSeanceDto.class
                )
        ).toList();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TicketIdNomClientNbPlacesSeanceDto findById(@PathVariable Integer id) {
        return objectMapper.convertValue(
                this.ticketService.findById(id),
                TicketIdNomClientNbPlacesSeanceDto.class
        );
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public TicketIdNomClientNbPlacesSeanceDto save(@RequestBody Ticket ticket) {
        return objectMapper.convertValue(
                this.ticketService.save(ticket),
                TicketIdNomClientNbPlacesSeanceDto.class
        );
    }

    @PutMapping(path = "/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public TicketIdNomClientNbPlacesSeanceDto update(@RequestBody Ticket ticket, @PathVariable Integer id) {
        return objectMapper.convertValue(
                this.ticketService.update(ticket, id),
                TicketIdNomClientNbPlacesSeanceDto.class
        );
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.ticketService.delete(id);
    }
}
