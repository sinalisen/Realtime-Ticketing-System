package lk.iit.ticket_system_example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Vendor {
    private @Id
    @GeneratedValue int vendorId;
    private String firstName;
    private String lastName;


    public Vendor() {

    }

    public Vendor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

