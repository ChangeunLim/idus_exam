package com.example.idus_exam.Member.model;

import com.example.idus_exam.Payment.model.Payment;
import com.example.idus_exam.emailVerify.model.EmailVerify;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
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
    @Pattern(regexp = "^[가-힣a-zA-Z]+$")
    private String username;
    @Pattern(regexp = "^[a-z]+$")
    private String nickname;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]+$")
    private String password;
    @Pattern(regexp = "^[0-9]+$")
    private int phonenumber;
    @Email @NonNull @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
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
