package com.example.idus_exam.Payment.model;

import com.example.idus_exam.Member.model.Member;
import lombok.Getter;

import java.time.LocalDateTime;

public class PaymentDto {
    @Getter
    public static class PaymentRegister {
        private String name;
        private String odernumber;
        private LocalDateTime paymentTime;

        public Payment toEntity(Member member) {
            return Payment.builder()
                    .name(name)
                    .odernumber(odernumber)
                    .paymentTime(paymentTime)
                    .member(member)
                    .build();
        }
    }
}
