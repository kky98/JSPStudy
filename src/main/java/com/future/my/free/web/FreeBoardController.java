package com.future.my.free.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.my.commons.service.CodeService;
import com.future.my.commons.vo.CodeVO;
import com.future.my.free.service.FreeBoardService;
import com.future.my.free.vo.FreeBoardSearchVO;
import com.future.my.free.vo.FreeBoardVO;

@Controller
@RequestMapping("/free")
public class FreeBoardController {

	@Autowired
	FreeBoardService freeBoardService;
	
	@Autowired
	CodeService codeService;
	
	@ModelAttribute("comList") // comList 로 board쪽에서는 모두 사용가능
	public List<CodeVO> getCodeList(){
		List<CodeVO> comList = codeService.getCodeList("BC00");
		return comList;
	}
	
	@RequestMapping("/freeList")
	public String freeBoardList(Model model
			, @ModelAttribute("searchVO") FreeBoardSearchVO searchVO) {
		List<FreeBoardVO> freeBoardList = 
				freeBoardService.getBoardList(searchVO);
		model.addAttribute("freeList", freeBoardList);
		
		return "free/freeList";
	}
}
