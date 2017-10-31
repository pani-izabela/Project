package com.crud.tasks.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SimpleEmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class());
    @Autowired
    private JavaMailSender javaMailSender;

    public void send(final Mail mail){
        LOGGER.info("Starting email preparation...");
        try {
            javaMailSender.send(createMailMessage(mail));
            LOGGER.info("Email has been sent.");
        }
        catch (MailException e){
            LOGGER.error("Failed to process email sending: ", e.getMessage(), e);
        }

    }

    private SimpleMailMesage createMailMessage(final Mail mail){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.stSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        return mailMessage;

    }
}
