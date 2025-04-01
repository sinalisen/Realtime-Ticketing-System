
package lk.iit.ticket_system_example.database;

import lk.iit.ticket_system_example.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}