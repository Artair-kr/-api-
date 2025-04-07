package com.teamproject.springboot.service;

import com.teamproject.springboot.repository.EmailVerification;
import com.teamproject.springboot.repository.EmailVerificationRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final EmailService emailService;
    private final EmailVerificationRepository emailVerificationRepository;

    public UserService(EmailService emailService, EmailVerificationRepository emailVerificationRepository) {
        this.emailService = emailService;
        this.emailVerificationRepository = emailVerificationRepository;
    }

    // 인증 코드 전송
    public void sendVerificationCode(String email) {
        String verificationCode = emailService.generateVerificationCode();
        emailService.sendVerificationEmail(email, verificationCode);

        // 이메일 인증 코드 저장
        EmailVerification emailVerification = new EmailVerification(email, verificationCode);
        emailVerificationRepository.save(emailVerification);
    }

    // 인증 코드 검증
    public boolean verifyCode(String email, String code) {
        EmailVerification emailVerification = emailVerificationRepository.findByEmail(email).orElse(null);
        if (emailVerification != null && emailVerification.getVerificationCode().equals(code)) {
            // 인증 성공
            emailVerificationRepository.delete(emailVerification);  // 인증 후 삭제 (선택 사항)
            return true;
        }
        return false;
    }
}
