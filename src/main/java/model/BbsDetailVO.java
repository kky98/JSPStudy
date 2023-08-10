package model;

public class BbsDetailVO {

	private String status;
	private int bbsNo;
	private String bbsContent;
	private String authorId;
	private String updateDt;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
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
		return "BbsDetailVO [status=" + status + ", bbsNo=" + bbsNo + ", bbsContent=" + bbsContent + ", authorId="
				+ authorId + ", updateDt=" + updateDt + "]";
	}

	

}
