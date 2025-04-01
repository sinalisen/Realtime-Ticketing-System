package lk.iit.ticket_system_example.database;


import lk.iit.ticket_system_example.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VendorRepository extends JpaRepository<Vendor, Integer> {
}


