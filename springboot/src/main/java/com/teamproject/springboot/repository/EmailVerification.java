package com.teamproject.springboot.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmailVerification {

    @Id
    private String email;  // 이메일을 식별자로 사용
    private String verificationCode;  // 인증 코드

    // 기본 생성자
    public EmailVerification() {}

    // 이메일과 인증 코드를 설정하는 생성자
    public EmailVerification(String email, String verificationCode) {
        this.email = email;
        this.verificationCode = verificationCode;
    }

    // Getter and Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
