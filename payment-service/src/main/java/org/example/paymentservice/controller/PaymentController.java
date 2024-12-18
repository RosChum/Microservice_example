package org.example.paymentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping
    public ResponseEntity<String> getAllPayment() {
        return ResponseEntity.ok("All payment received");
    }
}
