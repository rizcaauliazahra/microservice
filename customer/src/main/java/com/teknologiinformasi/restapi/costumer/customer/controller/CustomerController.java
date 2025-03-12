package com.teknologiinformasi.restapi.costumer.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teknologiinformasi.restapi.costumer.customer.model.Customer;
import com.teknologiinformasi.restapi.costumer.customer.service.CustomerService;

// import com.teknologiinformasi.restapi.model.Produk;
// import com.teknologiinformasi.restapi.service.ProdukService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {


   @Autowired
   private CustomerService customerService;


   // Endpoint untuk mengambil semua produk
   @GetMapping
   public List<Customer> getAllCustomer() {
       return customerService.getAllCustomers();
   }


   // Endpoint untuk mengambil produk berdasarkan id
   @GetMapping("/{id}")
   public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
       return customerService.getCustomerById(id)
               .map(customer -> ResponseEntity.ok().body(customer))
               .orElse(ResponseEntity.notFound().build());
   }


   // Endpoint untuk membuat produk baru
   @PostMapping
   public Customer createCustomer(@RequestBody Customer customer) {
       return customerService.createCustomer(customer);

   }


   // Endpoint untuk mengupdate produk yang sudah ada
   @PutMapping("/{id}")
   public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
       try {
           Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
           return ResponseEntity.ok(updatedCustomer);
       } catch (RuntimeException e) {
           return ResponseEntity.notFound().build();
       }
   }


   // Endpoint untuk menghapus produk
  @DeleteMapping("/{id}")
public ResponseEntity<Map<String, String>> deleteCustomer(@PathVariable Long id) {
   try {
       customerService.deleteCustomer(id);
       Map<String, String> response = new HashMap<>();
       response.put("message", "Customer berhasil dihapus");
       return ResponseEntity.ok(response);
   } catch (RuntimeException e) {
       Map<String, String> response = new HashMap<>();
       response.put("message", "Customer tidak ditemukan dengan id " + id);
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
   }
}
}
