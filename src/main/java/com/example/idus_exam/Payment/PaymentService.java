package com.example.idus_exam.Payment;

import com.example.idus_exam.Member.model.Member;
import com.example.idus_exam.Payment.model.Payment;
import com.example.idus_exam.Payment.model.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PaymentService {
    private PaymentRepository paymentRepository;

    public void register(PaymentDto.PaymentRegister dto, Member member) {
        Payment payment = paymentRepository.save(dto.toEntity(member));
    }

    @Transactional(readOnly = true)
    public PaymentDto.PaymentResponse read(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElse(null);
        return PaymentDto.PaymentResponse.from(payment);
    }
}
