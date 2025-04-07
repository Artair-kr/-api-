package com.teamproject.springboot.controller;

import com.teamproject.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 이메일로 인증 코드 전송
    @PostMapping("/send-verification-code")
    public String sendVerificationCode(@RequestParam String email) {
        userService.sendVerificationCode(email);
        return "인증 코드가 이메일로 전송되었습니다.";
    }

    // 인증 코드 검증
    @PostMapping("/verify-code")
    public String verifyCode(@RequestParam String email, @RequestParam String code) {
        boolean isVerified = userService.verifyCode(email, code);
        if (isVerified) {
            return "인증이 완료되었습니다.";
        } else {
            return "인증 코드가 잘못되었습니다.";
        }
    }
}
