package com.example.idus_exam.Payment.model;

import com.example.idus_exam.Member.model.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Getter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class PaymentResponse {
        private Long idx;
        private String name;
        private String odernumber;
        private LocalDateTime paymentTime;

        public static PaymentResponse from(Payment payment) {
            return PaymentResponse.builder()
                    .idx(payment.getIdx())
                    .name(payment.getName())
                    .odernumber(payment.getOdernumber())
                    .paymentTime(payment.getPaymentTime())
                    .build();
        }
    }
}
