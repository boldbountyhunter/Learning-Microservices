package com.microservices.paymentservice.service;

import com.microservices.paymentservice.entity.Payment;
import com.microservices.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment makePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    public List<Payment> getAllPaymentsByIds(List<Long> ids) {
        return paymentRepository.findAllByIdIn(ids);
    }
}