package com.example.idus_exam.emailVerify;

import com.example.idus_exam.emailVerify.model.EmailVerify;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailVerifyRepository extends JpaRepository<EmailVerify, Long> {
    Optional<Object> findByUuid(String uuid);
}
