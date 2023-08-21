package com.future.my.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.my.board.dao.IBoardDAO;
import com.future.my.board.vo.BoardVO;
import com.future.my.board.vo.ReplyVO;
import com.future.my.commons.SearchVO;

@Service
public class BoardService {
	
	@Autowired
	IBoardDAO dao;

	public List<BoardVO> getBoardList(){
		List<BoardVO> result = dao.getBoardList();
		return result;
	}
	public List<BoardVO> searchBoardList(SearchVO search){
		List<BoardVO> result = dao.searchBoardList(search);
		return result;
	}
	
	
	
	public void writeBoard(BoardVO board) throws Exception {
		int result = dao.writeBoard(board);
		if(result ==0) {
			throw new Exception();
		}
	}
	public BoardVO getBoard(int boardNo) throws Exception {
		BoardVO result = dao.getBoard(boardNo);
		if(result == null) {
			throw new Exception();
		}
		return result;
	}
	public void updateBoard(BoardVO board) throws Exception {
		int result = dao.updateBoard(board);
		if(result == 0) {
			throw new Exception();
		}
	}
	public void deleteBoard(int boardNo) throws Exception {
		int result = dao.deleteBoard(boardNo);
		if(result == 0) {
			throw new Exception();
		}
	}
	public ReplyVO getReply(String replyNo) throws Exception {
		ReplyVO result = dao.getReply(replyNo);
		if(result == null) {
			throw new Exception();
		}
		return result;
	}
	public int writeReply(ReplyVO reply) throws Exception {
		int result = dao.writeReply(reply);
		if(result == 0) {
			throw new Exception();
		}
		return result;
	}
	
	public List<ReplyVO> getReplyList(int boardNo){
		List<ReplyVO> result = dao.getReplyList(boardNo);
		return result;
	}
	
	public void delReply(String replyNo) throws Exception {
		int result = dao.delReply(replyNo);
		if(result ==0) {
			throw new Exception();
		}
	}
	
	
}
