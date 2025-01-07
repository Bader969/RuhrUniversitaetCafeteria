package service;

import domain.Payment;
import repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public void processPayment(Payment payment) {
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(payment);
    }

    public Optional<Payment> findPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public void refundPayment(Long paymentId) {
        Payment payment = findPaymentById(paymentId).orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.refund();
        paymentRepository.save(payment);
    }
}
