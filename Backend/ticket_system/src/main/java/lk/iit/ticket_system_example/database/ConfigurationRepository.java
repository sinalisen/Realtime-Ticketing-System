package lk.iit.ticket_system_example.database;


import lk.iit.ticket_system_example.database.ConfigurationRepository;
import lk.iit.ticket_system_example.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
    // Custom query methods can be added here if needed
}