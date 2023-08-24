package com.future.my.board.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.future.my.board.service.BoardService;
import com.future.my.board.vo.BoardVO;
import com.future.my.board.vo.ReplyVO;
import com.future.my.commons.SearchVO;
import com.future.my.commons.service.CodeService;
import com.future.my.commons.vo.CodeVO;
import com.future.my.member.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired 
	CodeService codeService;
	
	@ModelAttribute("comList") // comList 로 board쪽에서는 모두 사용가능
	public List<CodeVO> getCodeList(){
		List<CodeVO> comList = codeService.getCodeList(null);
		return comList;
	}
	
	
	@Autowired
	BoardService boardService; 
	
	@ExceptionHandler(Exception.class)
	public String errorView(Exception e) {
		e.printStackTrace();
		return "errorView";
	}
	
	@RequestMapping("/boardView")
	public String boardView(Model model, HttpSession session) {
		List<BoardVO> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		return "board/boardView";
	}
	@RequestMapping("/searchBoard")
	public String searchBoard(Model model, SearchVO search) {
		System.out.println(search);
		List<BoardVO> boardList = boardService.searchBoardList(search);
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
	
	@RequestMapping("/boardDetailView")
	public String boardDetailView(Model model,int boardNo) throws Exception {
		
	    BoardVO boardVO = boardService.getBoard(boardNo);
        List<ReplyVO> replyList = boardService.getReplyList(boardNo);
        model.addAttribute("replyList", replyList);
	    model.addAttribute("board", boardVO);
		
		return "board/boardDetailView";
	}
	@RequestMapping("/boardEditView")
	public String boardEditView(Model model,int boardNo) throws Exception {
		
	    BoardVO boardVO = boardService.getBoard(boardNo);
	    model.addAttribute("board", boardVO);
		
		return "board/boardEditView";
	}
	@PostMapping("/boardEditDo")
	public String boardEditDo(BoardVO board) throws Exception {
		boardService.updateBoard(board);
		return "redirect:/boardView";
	}
	
	@PostMapping("/boardDel")
	public String boardDel(int boardNo) throws Exception {
		boardService.deleteBoard(boardNo);
		return "redirect:/boardView";
	}
	
	@ResponseBody
	@PostMapping("/writeReplyDo")
    public ReplyVO writeReplyDo(@RequestBody ReplyVO reply) throws Exception {
		System.out.println(reply);
		//replyno생성
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		String uniquId = sdf.format(date);
		System.out.println(uniquId);
		// 임의의 아이디 생성후 저장 reply_no에 담아주기 		
		reply.setReplyNo(uniquId);
		// 댓글 저장		
		boardService.writeReply(reply);
		// 저장된 댓글 조회		
		ReplyVO result = boardService.getReply(uniquId);
		// 조회결과 리턴(저장 댓글을 화면에 바로 출력하기 위해)		
		return result;
	}
	
	@ResponseBody
	@PostMapping("/delReplyDo")
	public String delReplyDo(@RequestBody ReplyVO reply) throws Exception {
		String result = "fail";
		boardService.delReply(reply.getReplyNo());
		result ="success";
		return result;
	}
	
	
}
