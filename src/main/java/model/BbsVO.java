package model;

public class BbsVO {
	 private int rnum;     
     private int allCnt;     
     private int bbsNo;     
     private String bbsTitle;   
     private String authorId;   
     private String updateDt;
     
    public int getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}
     
	public BbsVO() {
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getAllCnt() {
		return allCnt;
	}
	public void setAllCnt(int allCnt) {
		this.allCnt = allCnt;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}
	@Override
	public String toString() {
		return "BbsVO [rnum=" + rnum + ", allCnt=" + allCnt + ", bbsNo=" + bbsNo + ", bbsTitle=" + bbsTitle
				+ ", authorId=" + authorId + ", updateDt=" + updateDt + "]";
	}
     
}
