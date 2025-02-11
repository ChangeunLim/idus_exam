package com.example.idus_exam.emailVerify;

import com.example.idus_exam.Member.model.Member;
import com.example.idus_exam.emailVerify.model.EmailVerify;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailVerifyService {
    private final EmailVerifyRepository emailVerifyRepository;
    private final JavaMailSender mailSender;

    public void sendEmail(String uuid, String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("환영 굿");
        message.setText(
                "http://localhost:8080/member/verify?uuid=" + uuid
        );

        mailSender.send(message);
    }

    public void signup(Long idx, String email) {
        String uuid = UUID.randomUUID().toString();

        Member member = Member.builder()
                .idx(idx)
                .build();

        // 이메일 인증 정보 저장
        emailVerifyRepository.save(EmailVerify.builder()
                .member(member)
                .uuid(uuid)
                .build());

        // 이메일 전송
        sendEmail(uuid, email);
    }

    public Member verify(String uuid) {
        EmailVerify emailVerify = emailVerifyRepository.findByUuid(uuid).orElseThrow();

        return  emailVerify.getMember();
    }
}
