package com.teknologiinformasi.restapi.payment.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasi.restapi.payment.model.Payment;
 

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}