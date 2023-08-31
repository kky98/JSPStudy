package com.future.my.chat.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.my.chat.service.ChatLogService;
import com.future.my.chat.service.RoomService;
import com.future.my.chat.vo.ChatLogVO;
import com.future.my.chat.vo.RoomVO;


@Controller
public class ChatController {
	
	@Autowired
	ChatLogService chatService;
	
	@Autowired
	RoomService roomService;
	
	@RequestMapping("/chatView")
	public String chatView(Model model, int roomNo) {
		
		List<ChatLogVO> chatList = chatService.getChatList(roomNo);
		RoomVO roomVO = roomService.getRoom(roomNo);
		
		model.addAttribute("room", roomVO);
		model.addAttribute("chatList", chatList);
		
		return "chat/chatView";
	}
	
	//채팅 메세지 전달
	@MessageMapping("/hello/{roomNo}")
	@SendTo("/subscribe/chat/{roomNo}")
	public ChatLogVO broadcasting(ChatLogVO chatVO) {
		
		chatService.insertChat(chatVO);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		chatVO.setSendDate(sdf.format(new Date()));
		// 상대방에게 전달됨.		
		return chatVO;
	}
}
