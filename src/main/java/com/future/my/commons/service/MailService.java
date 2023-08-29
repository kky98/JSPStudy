package com.future.my.commons.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	public void sendMail(String to, String title, String content) throws UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		
			MimeMessageHelper messageHelper;
			try {
				messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom("leeapgil@gmail.com", "관리자");
				messageHelper.setSubject(title);
				messageHelper.setTo(to);
				messageHelper.setText(content);
				mailSender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		
	}
}
