package lk.iit.ticket_system_example.controllers;


import lk.iit.ticket_system_example.database.CustomerRepository;
import lk.iit.ticket_system_example.model.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/add-customer")
    public String addPerson(@RequestBody Customer customer) {
        // Save the person object to the repository
        customerRepository.save(customer);
        return "Added " + customer.getFirstName();

    }

}
