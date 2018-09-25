package com.netdevs.emailclient.controller;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netdevs.emailclient.components.EmailService;
import com.netdevs.emailclient.model.AttachedMail;
import com.netdevs.emailclient.model.SimpleMail;

@RestController
@RequestMapping("/api")
public class MailController {

	@Autowired
	private EmailService emailService;

	// Use "localhost:8080/api/check" in browser URL
	@PostMapping("/check")
	public String hello() {

		return "Yes REST API is working";
	}

	// Use "localhost:8080/api/sendsimple" in browser URL
	@PostMapping("/sendsimple")
	public String sendMail(@Valid @RequestBody SimpleMail sm) {

		// You have to send data through UI or set data manually to this method
		emailService.sendSimpleMessage(sm.getTo(), sm.getSubject(), sm.getText());

		return "Mail sent success!";
	}

	// Use "localhost:8080/api/sendattach" in browser URL
	@PostMapping("/sendattach")
	public String sendMailAttachment(@Valid @RequestBody AttachedMail am) throws MessagingException {

		// You have to send data through UI or set data manually to this method
		emailService.sendMessageWithAttachment(am.getTo(), am.getSubject(), am.getText(), am.getPathToAttachment());

		return "Attached Mail sent success!";
	}
}
