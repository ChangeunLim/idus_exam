package com.example.idus_exam.Payment;

import com.example.idus_exam.Member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private final PatmentService patmentService;

    @PostMapping("/register")
    public void register(@AuthenticationPrincipal Member member) {
        patmentService.register(dto, member);
    }
}
