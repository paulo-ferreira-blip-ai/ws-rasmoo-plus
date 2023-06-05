package com.cliente.ws.rasmooplus.integration.impl;

import com.cliente.ws.rasmooplus.integration.MailIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailIntegrationImpl implements MailIntegration {
    @Autowired
    private JavaMailSender javaMailSender;

    //configuração para envio de email
    @Override
    public void send(String mailTo, String message, String subject) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailTo);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        javaMailSender.send(simpleMailMessage);

    }
}
