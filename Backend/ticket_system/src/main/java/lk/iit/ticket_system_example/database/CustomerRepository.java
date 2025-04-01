package lk.iit.ticket_system_example.database;

import lk.iit.ticket_system_example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}