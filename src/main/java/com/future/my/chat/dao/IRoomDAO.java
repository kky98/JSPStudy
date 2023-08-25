package com.future.my.chat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.future.my.chat.vo.RoomVO;

@Mapper
public interface IRoomDAO {
	//전체 채팅방 리스트 
	public List<RoomVO> getRoomList();
	//채팅방 정보조회
	public RoomVO getRoom(int roomNo);
	//채팅방 저장 
	public int createRoom(RoomVO roomVO);
}
