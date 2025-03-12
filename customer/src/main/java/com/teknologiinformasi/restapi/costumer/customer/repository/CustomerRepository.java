package com.teknologiinformasi.restapi.costumer.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasi.restapi.costumer.customer.model.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

