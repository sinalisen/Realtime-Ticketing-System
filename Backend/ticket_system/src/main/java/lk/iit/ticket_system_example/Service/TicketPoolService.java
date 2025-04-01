package lk.iit.ticket_system_example.Service;



import org.springframework.stereotype.Service;

@Service
public class TicketPoolService {

    private int availableTickets;

    public TicketPoolService(int initialTickets) {
        this.availableTickets = initialTickets;
    }

    public synchronized boolean purchaseTickets(int quantity) {
        if (quantity <= availableTickets) {
            availableTickets -= quantity;
            return true;
        } else {
            return false;
        }
    }

    public synchronized void addTickets(int quantity) {
        availableTickets += quantity;
    }

    public synchronized int getAvailableTickets() {
        return availableTickets;
    }
}
