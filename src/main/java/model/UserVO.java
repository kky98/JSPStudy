package model;

// value object 
public class UserVO {
	
	private String userId;
	private String userPw;
	private String userNm;
	private String userMail;
	private int userMileage;
	private String createDt;
	private String updateDt;
	private String useYn;
	
	public UserVO(String userId, String userPw, String userNm) {
		this.userId = userId;
		this.userPw = userPw;
		this.userNm = userNm;
	}
	public UserVO() {
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public int getUserMileage() {
		return userMileage;
	}
	public void setUserMileage(int userMileage) {
		this.userMileage = userMileage;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPw=" + userPw + ", userNm=" + userNm + ", userMail=" + userMail
				+ ", userMileage=" + userMileage + ", createDt=" + createDt + ", updateDt=" + updateDt + ", useYn="
				+ useYn + "]";
	}
	
}