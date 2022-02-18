package com.cg;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@Autowired
	GmailService sendingEmailApplication;

	@RequestMapping(value = "/sendemail")
	public String send() throws AddressException, MessagingException, IOException {
	   //sendEmail();
		sendingEmailApplication.sendEmailWithAttachment();
	   return "Email sent successfully";   
	}
	@RequestMapping(value = "/send")
	public String send1() throws AddressException, MessagingException, IOException {
	   //sendEmail();
		sendingEmailApplication.sendEmail();
	   return "Email sent successfully";   
	}
	
}


