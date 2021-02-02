package sgsits.cse.dis.user.controller;

import com.sun.mail.util.MailConnectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import sgsits.cse.dis.user.constants.DisConstants;
import sgsits.cse.dis.user.model.EventAttachment;
import sgsits.cse.dis.user.service.EmailService;

import java.rmi.UnknownHostException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Controller
@EnableAsync
public class EmailController {

    @Autowired
    private EmailService emailService;
    
    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendSimpleEmail(String subject, String text , Set<EventAttachment> attachments, String... cclist) throws MessagingException,MailConnectException,UnknownHostException, SQLException
    {
        // Create a Simple MailMessage.
    	MimeMessage message = mailSender.createMimeMessage();
    	MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(DisConstants.DIS_EMAIL);
        helper.setCc(cclist);
        helper.setSubject(subject);
        helper.setText(text);
        if(attachments!=null) {
            if(!attachments.isEmpty()) {
                for (EventAttachment attachment : attachments) {
                    helper.addAttachment(attachment.getFileName(), new ByteArrayResource(attachment.getFileData()));
                }
            }
        }
        emailService.sendEmail(message);
    }

}