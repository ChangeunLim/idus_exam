package com.example.idus_exam.Member.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

public class MemberDto {
    @Getter
    public static class SignupRequest {
        private String email;
        private String password;
        private String nickName;

        public Member toEntity(String encodedPassword, String type) {
            if(type.equals("USER")) {
                return Member.builder()
                        .email(email)
                        .password(encodedPassword)
                        .nickname(nickName)
                        .role("USER")
                        .build();
            } else {
                return Member.builder()
                        .email(email)
                        .password(encodedPassword)
                        .nickname(nickName)
                        .role("INSTRUCTOR")
                        .build();
            }
        }
    }

    @Getter
    public static class MemberResponse {
        private Long idx;
        private String username;
        private String nickname;
        private String email;
        private int phonenumber;
        private LocalDateTime lastPaymentData;

        public static MemberResponse from(Member member) {
            MemberResponse response = new MemberResponse();
            response.idx = member.getIdx();
            response.nickname = member.getNickname();
            response.email = member.getEmail();
            response.phonenumber = member.getPhonenumber();
            response.username = member.getUsername();
            return response;
        }
    }
}
