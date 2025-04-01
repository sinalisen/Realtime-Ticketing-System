package lk.iit.ticket_system_example.controllers;

import lk.iit.ticket_system_example.database.TicketRepository;
import lk.iit.ticket_system_example.model.Ticket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController{
    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    @PostMapping("/add-Ticket")
    public String addPerson(@RequestBody Ticket ticket) {
        // Save the person object to the repository
        ticketRepository.save(ticket);
        return "Added" + ticket.getTicketPrice();
    }
}
