package com.example.idus_exam.Member;

import com.example.idus_exam.Member.model.MemberDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/verify")
    public void verify(String uuid) {
        memberService.verify(uuid);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody MemberDto.SignupRequest dto) {
        memberService.signup(dto);
    }

    @PostMapping("/instructor/signup")
    public void instructorSignup(@RequestBody MemberDto.SignupRequest dto) {
        memberService.instructorSignup(dto);
    }
}
