package com.future.my.board.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.my.board.service.BoardService;
import com.future.my.board.vo.BoardVO;
import com.future.my.member.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService; 
	
	@RequestMapping("/boardView")
	public String boardView(Model model, HttpSession session) {
		List<BoardVO> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		return "board/boardView";
	}
	
	@RequestMapping("/boardWriteView")
	public String boardWriteView(HttpSession session) {
		
		if(session.getAttribute("login") == null) {
			return "redirect:/loginView";
		}
		return "board/boardWriteView";
	}
	@RequestMapping("/boardWriteDo")
	public String boardWriteView(BoardVO board,HttpSession session) throws Exception {
		
		MemberVO login = (MemberVO) session.getAttribute("login");
		board.setMemId(login.getMemId());
		boardService.writeBoard(board);
		
		return "redirect:/boardView";
	}
	
	
}
