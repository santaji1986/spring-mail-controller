package com.example.demo;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	JavaMailSender javaMailSender;

	@RequestMapping("/hello")
	public String hello() throws MessagingException {
		sendMail();
		return "Hello";
	}

	private void sendMail() throws MessagingException {

		final MimeMessage message = javaMailSender.createMimeMessage();
		final MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("log.india@yestelecom.nl");
		helper.setTo(new String[] { "santaji.suryawanshi@yestelecom.nl","santaji1986@gmail.com" });
		helper.setSubject("TEST mail.");
		helper.setText("Mail Boday", true);
		javaMailSender.send(message);

	}
}
