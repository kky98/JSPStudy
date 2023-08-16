package com.future.my.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.future.my.board.vo.BoardVO;

@Mapper
public interface IBoardDAO {
	public List<BoardVO> getBoardList();
	public int writeBoard(BoardVO board);
}
