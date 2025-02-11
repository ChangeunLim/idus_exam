package com.example.idus_exam.Member;

import com.example.idus_exam.Member.model.Member;
import com.example.idus_exam.Member.model.MemberDto;
import com.example.idus_exam.emailVerify.EmailVerifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailVerifyService emailVerifyService;

    public void signup(MemberDto.SignupRequest dto) {
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        Member member = memberRepository.save(dto.toEntity(encodedPassword, "USER"));
        emailVerifyService.signup(member.getIdx(), member.getEmail());
    }

    public void instructorSignup(MemberDto.SignupRequest dto) {
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        memberRepository.save(dto.toEntity(encodedPassword, "INSTRUCTOR"));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> result = memberRepository.findByUser(username);
        if (result.isPresent()) {
            Member member = result.get();
            return member;
        }
        return null;
    }

    public List<Member> list() {
        List<Member> members = memberRepository.findAll();
        return members;
    }

    public MemberDto.MemberResponse read(Long idx) {
        Optional<Member> result = memberRepository.findById(idx);

        if (result.isPresent()) {
            Member member = result.get();
            return MemberDto.MemberResponse.from(member);
        }
        return null;
    }

    public void verify(String uuid) {
        Member member = emailVerifyService.verify(uuid);
        if (member != null) {
            member.verify();
            memberRepository.save(member);
        }
    }
}
