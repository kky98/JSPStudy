package com.future.my.chat.vo;

public class RoomVO {
	private int roomNo;      /*방 번호 */
	private String roomName; /*방 이름 */
	private String memId;    /*방장 아이디 */
	private String memNm;    /*방장 이름 */ 
	private String regDate;  /*방 생성일 */
	private String delYn;    /*방 삭제 여부 */
	
	@Override
	public String toString() {
		return "RoomVO [roomNo=" + roomNo + ", roomName=" + roomName + ", memId=" + memId + ", memNm=" + memNm
				+ ", regDate=" + regDate + ", delYn=" + delYn + "]";
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	
	
}
