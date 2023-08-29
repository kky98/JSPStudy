package com.future.my.commons.web;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.my.commons.service.MailService;
import com.future.my.commons.vo.MailVO;

@Controller
@EnableAsync
public class MailController {
	@Autowired
	private MailService mailService;
	
	@RequestMapping("/sendMailDo")
	public String sendMailDo(MailVO mailVO) throws UnsupportedEncodingException {
		System.out.println(mailVO);
//		mailService.sendMail("nickapgl@gmail.com","[미래융합입니다!!!!]","안녕하세요 시험결과가....");
		return "home";
	}
	
}
