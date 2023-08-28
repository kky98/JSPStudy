package com.future.my.chat.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.my.chat.vo.ChatLogVO;

@Controller
public class ChatController {
	@RequestMapping("/chatView")
	public String chatView(Model model, int roomNo) {
		
		return "chat/chatView";
	}
	
	//채팅 메세지 전달
	@MessageMapping("/hello/{roomNo}")
	@SendTo("/subscribe/chat/{roomNo}")
	public ChatLogVO broadcasting(ChatLogVO chatVO) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		chatVO.setSendDate(sdf.format(new Date()));
		// 상대방에게 전달됨.		
		return chatVO;
	}
}
