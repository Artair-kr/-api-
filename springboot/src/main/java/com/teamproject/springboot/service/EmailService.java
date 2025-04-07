package com.teamproject.springboot.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendVerificationEmail(String toEmail, String verificationCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("이메일 인증 코드");
        message.setText("인증 코드: " + verificationCode);
        javaMailSender.send(message);
    }

    public String generateVerificationCode() {
        int code = (int) (Math.random() * 1000000);
        return String.format("%06d", code);  // 6자리 인증 코드 반환
    }
}
