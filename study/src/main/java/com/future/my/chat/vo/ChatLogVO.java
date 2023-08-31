package com.future.my.chat.vo;

public class ChatLogVO {
	
	private int chatNo;       /**대화내용 pk */
	private String memId;     /**작성자 id */
	private String memNm;     /**작성자 이름 */
	private int roomNo;       /**채팅방 id */  
	private String chatMsg;   /**대화내용*/
	private String sendDate;  /**대화 전송 시간 */
	
	@Override
	public String toString() {
		return "ChatLogVO [chatNo=" + chatNo + ", memId=" + memId + ", memNm=" + memNm + ", roomNo=" + roomNo
				+ ", chatMsg=" + chatMsg + ", sendDate=" + sendDate + "]";
	}
	public int getChatNo() {
		return chatNo;
	}
	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
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
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getChatMsg() {
		return chatMsg;
	}
	public void setChatMsg(String chatMsg) {
		this.chatMsg = chatMsg;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	
}
