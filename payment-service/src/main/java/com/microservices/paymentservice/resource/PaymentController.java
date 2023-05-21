package com.microservices.paymentservice.resource;

import com.microservices.paymentservice.entity.Payment;
import com.microservices.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("")
    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.makePayment(payment), HttpStatus.ACCEPTED);
    }

    @PostMapping("/get-payment-by-ids")
    public ResponseEntity<List<Payment>> getAllPaymentByIds(@RequestBody List<Long> paymentIds) {
        return new ResponseEntity<>(paymentService.getAllPaymentsByIds(paymentIds), HttpStatus.OK);
    }
}
