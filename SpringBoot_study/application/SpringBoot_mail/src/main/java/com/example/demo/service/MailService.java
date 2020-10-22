package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * @Classname MailService
 * @Description TODO
 * @Date 2020/10/14 23:50
 * @Created by CodingGorit
 * @Version 1.0
 */
@Component
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendSimpleMail(String from,String to,String cc,String subject,String content) {
        SimpleMailMessage simpMsg = new SimpleMailMessage();
        simpMsg.setFrom(from); // 发送者
        simpMsg.setTo(to);  // 收件人
        simpMsg.setCc(cc);  // 抄送人
        simpMsg.setSentDate(new Date());
        simpMsg.setSubject(subject); // 邮件主题
        simpMsg.setText(content); // 邮件内容
        javaMailSender.send(simpMsg);
    }
}
