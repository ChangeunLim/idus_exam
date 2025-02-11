package com.example.idus_exam.Member;

import com.example.idus_exam.Member.model.Member;
import com.example.idus_exam.Member.model.MemberDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/read")
    public ResponseEntity<MemberDto.MemberResponse> read(@PathVariable String email) {
        MemberDto.MemberResponse res = memberService.read(email);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Member>> list() {
        List<Member> members = memberService.list();
        return ResponseEntity.ok(members);
    }
}
