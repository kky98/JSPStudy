package com.future.my.commons.vo;

public class CodeVO {
	
	private String commCd;      /*코드*/
	private String commNm;	    /*코드명*/
	private String commParent;	/*부모 코드*/
	
	public CodeVO() {
	}
	
	@Override
	public String toString() {
		return "CodeVO [commCd=" + commCd + ", commNm=" + commNm + ", commParent=" + commParent + "]";
	}

	public String getCommCd() {
		return commCd;
	}
	public void setCommCd(String commCd) {
		this.commCd = commCd;
	}
	public String getCommNm() {
		return commNm;
	}
	public void setCommNm(String commNm) {
		this.commNm = commNm;
	}
	public String getCommParent() {
		return commParent;
	}
	public void setCommParent(String commParent) {
		this.commParent = commParent;
	}
	
	
}
