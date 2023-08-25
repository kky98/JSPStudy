package com.future.my.chat.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.my.chat.service.RoomService;
import com.future.my.chat.vo.RoomVO;

@Controller
public class RoomController {
	@Autowired
	RoomService roomService;
	
	@RequestMapping("/chatListView")
	public String chatListView(Model model) {
		List<RoomVO> roomList = roomService.getRoomList();
		model.addAttribute("roomList", roomList);
		return "chat/chatListView";
	}
}
