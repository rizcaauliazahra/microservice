package com.teknologiinformasi.restapi.costumer.customer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer") 
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String name;  
    private String email; 
    private String addres; 

    // Constructor tanpa parameter
    public Customer() {}

    // Constructor dengan parameter
    public Customer(String name, String email, String addres) {
        this.name = name;
        this.email = email;
        this.addres = addres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddres() { // Perbaikan di sini
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
