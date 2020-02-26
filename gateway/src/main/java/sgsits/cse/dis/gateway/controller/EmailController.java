package sgsits.cse.dis.gateway.controller;

import java.rmi.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;

import com.sun.mail.util.MailConnectException;

import sgsits.cse.dis.gateway.model.Email;
import sgsits.cse.dis.gateway.service.EmailService;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    public void sendSimpleEmail(String to, String subject, String text) throws MailConnectException,UnknownHostException
    {
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Email.DIS_EMAIL);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailService.sendEmail(message);
    }

}
