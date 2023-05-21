package com.microservices.moviebookingservice.externalService;

import com.microservices.moviebookingservice.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentService {

    @PostMapping("/payment")
    public Payment makePayment(@RequestBody Payment payment);

    @PostMapping("/payment/get-payment-by-ids")
    public List<Payment> getAllPaymentByIds(@RequestBody List<Long> paymentIds);


}
