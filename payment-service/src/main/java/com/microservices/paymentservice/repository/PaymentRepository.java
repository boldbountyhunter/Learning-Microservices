package com.microservices.paymentservice.repository;

import com.microservices.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    public List<Payment> findAllByIdIn(List<Long> paymentIds);

}
