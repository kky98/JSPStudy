package com.future.my.commons.vo;

import java.util.List;

public class MailVO {

	private String title;
	private String content;
	private List<String> email;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getEmail() {
		return email;
	}
	public void setEmail(List<String> email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MailVO [title=" + title + ", content=" + content + ", email=" + email + "]";
	}
	
	
}
