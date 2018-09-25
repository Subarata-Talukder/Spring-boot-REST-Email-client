package com.netdevs.emailclient.components;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	public JavaMailSender emailSender;

	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {
		// TODO Auto-generated method stub

		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper;

		try {
			helper = new MimeMessageHelper(message, true);

			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);

			FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
			helper.addAttachment("Attached", file);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		emailSender.send(message);
	}

	public void sendSimpleMessage(String to, String subject, String text) {
		// TODO Auto-generated method stub

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);

		emailSender.send(message);
	}
}
