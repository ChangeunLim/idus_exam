package com.example.idus_exam.Payment;

import com.example.idus_exam.Payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
