package com.example.idus_exam.Payment.model;

import com.example.idus_exam.Member.model.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;
    private String odernumber;
    private String name;
    private LocalDateTime paymentTime;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;
}
