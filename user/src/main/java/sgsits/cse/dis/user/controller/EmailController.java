package sgsits.cse.dis.user.controller;

import com.sun.mail.util.MailConnectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import sgsits.cse.dis.user.constants.DisConstants;
import sgsits.cse.dis.user.service.EmailService;

import java.rmi.UnknownHostException;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    public void sendSimpleEmail(String subject, String text, String... cclist) throws MailConnectException,UnknownHostException
    {
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(DisConstants.DIS_EMAIL);
        message.setCc(cclist);
        message.setSubject(subject);
        message.setText(text);
        emailService.sendEmail(message);
    }

}
