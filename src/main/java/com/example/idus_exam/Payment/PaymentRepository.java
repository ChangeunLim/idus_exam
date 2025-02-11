package com.example.idus_exam.Payment;

import com.example.idus_exam.Member.model.Member;
import com.example.idus_exam.Payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findTopByMemberOrderByPaymentTimeDesc(Member member);
}
