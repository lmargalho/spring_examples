package com.workshop;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "Select c from Customer c where id = ?1")
    List<Customer> findCustomersById(Long id);
}
