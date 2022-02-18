package com.cg;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service 
public class GmailService {

	
	@Autowired
    private JavaMailSender javaMailSender;

	void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("suryavashikajal65@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");
        

        javaMailSender.send(msg);

    }
	
	void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        
    //    helper.setTo("suryavanshikajal65@gmail.com");
       // helper.setTo("aaryavani10@gmail.com");
        helper.setTo(new String[] {"suryavanshikajal65@gmail.com","monasuryawanshi9@gmail.com"});

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

		// hardcoded a file path
        FileSystemResource file = new FileSystemResource(new File("C:\\Users\\SWSURYAW\\Pictures\\wallpaper\\capgemini.jpg"));

        helper.addAttachment("ssl4.png", file);

        javaMailSender.send(msg);

    }	
}

