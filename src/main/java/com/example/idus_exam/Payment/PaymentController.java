package com.example.idus_exam.Payment;

import com.example.idus_exam.Member.model.Member;
import com.example.idus_exam.Payment.model.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/register")
    public void register(@AuthenticationPrincipal Member member, @RequestBody PaymentDto.PaymentRegister dto) {
        paymentService.register(dto, member);
    }

    @GetMapping("/{paymentIdx")
    public ResponseEntity<PaymentDto.PaymentResponse> get(@PathVariable Long paymentIdx) {
        PaymentDto.PaymentResponse response = paymentService.read(paymentIdx);
        return ResponseEntity.ok(response);
    }
}
