package com.future.my.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.my.chat.dao.IChatLogDAO;
import com.future.my.chat.vo.ChatLogVO;

@Service
public class ChatLogService {
	@Autowired
	IChatLogDAO dao;
	
	public List<ChatLogVO> getChatList(int roomNo){
		return dao.getChatList(roomNo);
	}
	public void insertChat(ChatLogVO chatLogVO) {
		dao.insertChat(chatLogVO);
	}
}
