package com.example.idus_exam.Payment;

import com.example.idus_exam.Member.model.Member;
import com.example.idus_exam.Payment.model.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private final PatmentService patmentService;

    @PostMapping("/register")
    public void register(@AuthenticationPrincipal Member member) {
        patmentService.register(dto, member);
    }

    @GetMapping("/list")
    public ResponseEntity<List<PaymentDto.PaymentResponse>> list() {
        List<PaymentDto.PaymentResponse> res = patmentService.list();
        return ResponseEntity.ok(res);
    }
}
