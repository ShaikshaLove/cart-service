package io.s3soft.cartservice.dto;

public class SuccessResponse {
	
	private Object content;
	private Integer status;
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public SuccessResponse(Object content, Integer status) {
		super();
		this.content = content;
		this.status = status;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public SuccessResponse() {
		super();
	}
	
}
