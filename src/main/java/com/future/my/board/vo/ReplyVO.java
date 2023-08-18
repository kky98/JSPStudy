package com.future.my.board.vo;

public class ReplyVO {
	
	    private String replyNo;
	    private int boardNo;
	    private String memId;
	    private String memNm;
	    private String replyContent;
	    private String replyDate; 
	    private String delYn;
		public ReplyVO() {
			super();
		}
		public ReplyVO(String replyNo, int boardNo, String memId, String memNm, String replyContent, String replyDate,
				String delYn) {
			this.replyNo = replyNo;
			this.boardNo = boardNo;
			this.memId = memId;
			this.memNm = memNm;
			this.replyContent = replyContent;
			this.replyDate = replyDate;
			this.delYn = delYn;
		}
		public String getReplyNo() {
			return replyNo;
		}
		public void setReplyNo(String replyNo) {
			this.replyNo = replyNo;
		}
		public int getBoardNo() {
			return boardNo;
		}
		public void setBoardNo(int boardNo) {
			this.boardNo = boardNo;
		}
		public String getMemId() {
			return memId;
		}
		public void setMemId(String memId) {
			this.memId = memId;
		}
		public String getMemNm() {
			return memNm;
		}
		public void setMemNm(String memNm) {
			this.memNm = memNm;
		}
		public String getReplyContent() {
			return replyContent;
		}
		public void setReplyContent(String replyContent) {
			this.replyContent = replyContent;
		}
		public String getReplyDate() {
			return replyDate;
		}
		public void setReplyDate(String replyDate) {
			this.replyDate = replyDate;
		}
		public String getDelYn() {
			return delYn;
		}
		public void setDelYn(String delYn) {
			this.delYn = delYn;
		}
	    
		
	    
}
