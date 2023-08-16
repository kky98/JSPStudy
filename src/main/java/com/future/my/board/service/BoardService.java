package com.future.my.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.my.board.dao.IBoardDAO;
import com.future.my.board.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	IBoardDAO dao;

	public List<BoardVO> getBoardList(){
		List<BoardVO> result = dao.getBoardList();
		return result;
	}
	public void writeBoard(BoardVO board) throws Exception {
		int result = dao.writeBoard(board);
		if(result ==0) {
			throw new Exception();
		}
	}
}
