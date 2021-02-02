package sgsits.cse.dis.user.service;

import javax.mail.internet.MimeMessage;

public interface EmailService {
    public void sendEmail(MimeMessage email);
}
