package com.future.my.commons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.my.commons.dao.ICodeDAO;
import com.future.my.commons.vo.CodeVO;

@Service
public class CodeService {
	@Autowired
	ICodeDAO codeDao;
	
	public List<CodeVO> getCodeList(String commParent){
		List<CodeVO> codeList = codeDao.getCodeList(commParent);
		return codeList;
	}
}
