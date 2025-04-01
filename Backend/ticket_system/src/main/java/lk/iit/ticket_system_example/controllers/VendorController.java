package lk.iit.ticket_system_example.controllers;

import lk.iit.ticket_system_example.database.VendorRepository;
import lk.iit.ticket_system_example.model.Vendor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VendorController {
    private final VendorRepository vendorRepository;

    public VendorController(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @PostMapping("/add-Vender")
    public String addPerson(@RequestBody Vendor vendor) {
        // Save the person object to the repository
        vendorRepository.save(vendor);
        return "Added " + vendor.getFirstName();
    }

}

