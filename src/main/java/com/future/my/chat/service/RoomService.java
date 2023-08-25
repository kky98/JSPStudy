package com.future.my.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.my.chat.dao.IRoomDAO;
import com.future.my.chat.vo.RoomVO;

@Service
public class RoomService {
	@Autowired
	IRoomDAO dao;
	
	public List<RoomVO> getRoomList(){
		return dao.getRoomList();
	}
	public RoomVO getRoom(int roomNo) {
		return dao.getRoom(roomNo);
	}
	public void createRoom(RoomVO roomVO) {
		dao.createRoom(roomVO);
	}
}
