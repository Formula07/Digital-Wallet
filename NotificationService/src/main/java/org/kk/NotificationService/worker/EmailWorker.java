package org.kk.NotificationService.worker;

import jakarta.mail.internet.MimeMessage;
import org.kk.NotificationService.utility.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailWorker {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(String email, String name, String userIdentifier, String userIdentifierValue){

//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setSubject("welcome to kartikey's E Wallet!");
//        simpleMailMessage.setTo(email);
//        simpleMailMessage.setText("hello guys, this is my Digital Wallet Application, I hope you will love it!!!");
//        javaMailSender.send(simpleMailMessage);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            System.out.println("inside the send email notification method by kartikey");
            MimeMessageHelper mail = new MimeMessageHelper(mimeMessage, true);
            String emailContent = EmailTemplate.EMAIL_TEMPLATE;
            emailContent = emailContent.replaceAll("==name==",name);
            emailContent = emailContent.replaceAll("==document==",userIdentifier);
            emailContent = emailContent.replaceAll("==documentNo==",userIdentifierValue);
            mail.setText(emailContent,true);
            mail.setTo(email);
            mail.setFrom("walletgfg@gmail.com");
            mail.setSubject("Welcome to Kartikey's E Wallet Application");
            javaMailSender.send(mimeMessage);
            System.out.println("Email has been sent to User");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
