package controller;

import domain.Payment;
import service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public void processPayment(@RequestBody Payment payment) {
        paymentService.processPayment(payment);
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.findPaymentById(id);
        return payment.orElse(null);
    }

    @PostMapping("/{id}/refund")
    public void refundPayment(@PathVariable Long id) {
        paymentService.refundPayment(id);
    }
}

