package com.future.my.commons.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.future.my.commons.vo.CodeVO;

@Mapper
public interface ICodeDAO {
	public List<CodeVO> getCodeList(String commParent);
}
