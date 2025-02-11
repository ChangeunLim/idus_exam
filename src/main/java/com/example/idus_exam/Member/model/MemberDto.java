package com.example.idus_exam.Member.model;

import lombok.Getter;

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
}
