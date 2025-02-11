package com.example.idus_exam.Member.model;

import com.example.idus_exam.Payment.model.Payment;
import com.example.idus_exam.emailVerify.model.EmailVerify;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String username;
    private String nickname;
    private String password;
    private int phonenumber;
    private String email;
//    private boolean gender;
    private String role;
    private boolean enabled;

    @OneToMany(mappedBy = "member")
    private List<EmailVerify> emailVerifyList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Payment> paymentList = new ArrayList<>();

    public void verify() { this.enabled = true; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);

        authorities.add(grantedAuthority);
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }
}
