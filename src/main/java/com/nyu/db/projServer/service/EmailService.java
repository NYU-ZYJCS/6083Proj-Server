package com.nyu.db.projServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerificationCode(String to, String verificationCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("1219637652@qq.com");
        message.setSubject("Verification Code");
        message.setText("Your Verification Code is：" + verificationCode);
        javaMailSender.send(message);
    }
}
