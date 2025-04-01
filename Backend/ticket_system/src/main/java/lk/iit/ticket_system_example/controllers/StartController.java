package lk.iit.ticket_system_example.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the Ticket Management System!";
    }
}
