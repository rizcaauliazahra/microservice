package com.teknologiinformasi.restapi.costumer.customer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknologiinformasi.restapi.costumer.customer.model.Customer;
import com.teknologiinformasi.restapi.costumer.customer.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Mengambil semua customer
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Mengambil customer berdasarkan ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Menambahkan customer baru
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Mengupdate data customer
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer tidak ditemukan dengan id " + id));

        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setAddres(customerDetails.getAddres());

        return customerRepository.save(customer);
    }

    // Menghapus customer berdasarkan ID
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer tidak ditemukan dengan id " + id));
        customerRepository.delete(customer);
    }
}
