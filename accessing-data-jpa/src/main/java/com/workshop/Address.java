package com.workshop;

import javax.persistence.*;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    @OneToMany(mappedBy = "address",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Customer> customers;

    public Address() {
        super();
    }

    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
