package lk.iit.ticket_system_example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ticket {
    private @Id
    @GeneratedValue int TicketId;
    private double ticketPrice;

    public Ticket(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    public Ticket() {}

    public int getTicketId(){
        return TicketId;
    }

    public void setTicketId(int ticketId) {
        TicketId = ticketId;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
