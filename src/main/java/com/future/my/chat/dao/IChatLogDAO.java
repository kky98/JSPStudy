package com.future.my.chat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.future.my.chat.vo.ChatLogVO;

@Mapper
public interface IChatLogDAO {
	public List<ChatLogVO> getChatList(int roomNo);
	public int insertChat(ChatLogVO chatVO);
}
