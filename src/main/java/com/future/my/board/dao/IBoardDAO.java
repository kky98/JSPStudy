package com.future.my.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.future.my.board.vo.BoardVO;
import com.future.my.board.vo.ReplyVO;
import com.future.my.commons.SearchVO;

@Mapper
public interface IBoardDAO {
	public List<BoardVO> getBoardList();
	public List<BoardVO> searchBoardList(SearchVO search);
	public int writeBoard(BoardVO board);
	public BoardVO getBoard(int boardNo);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int boardNo);
	
	public ReplyVO getReply(String replyNo);
	public int writeReply(ReplyVO reply);
	public List<ReplyVO> getReplyList(int boardNo);
	
	public int delReply(String replyNo);
}
