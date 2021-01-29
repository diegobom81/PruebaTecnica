package com.bankservices.wrapper;

public class WrapperResponse<T> {

	private boolean success;
	private String message;
	private T response;
	
	public WrapperResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WrapperResponse(boolean success, String message, T response) {
		super();
		this.success = success;
		this.message = message;
		this.response = response;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}
}
