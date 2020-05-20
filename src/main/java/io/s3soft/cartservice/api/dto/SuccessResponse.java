package io.s3soft.cartservice.api.dto;

public class SuccessResponse<T> {
	private T content;
	private int satus;
	public T getContent() {
		return content;
	}
	public void setContent(T content) {
		this.content = content;
	}
	public int getSatus() {
		return satus;
	}
	public void setSatus(int satus) {
		this.satus = satus;
	}
	public SuccessResponse(T content, int satus) {
		super();
		this.content = content;
		this.satus = satus;
	}
		
}
