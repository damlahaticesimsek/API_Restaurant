package com.restaurant.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResponseWrapperBase<T> {

	private boolean success;
	private String message;
	@JsonIgnore
	private Exception exception;

	public ResponseWrapperBase() {
		this.success = true;
	}

	public ResponseWrapperBase(Exception exception) {
		this.exception = exception;
		this.success = false;
		this.message = exception.getMessage();
	}

	public ResponseWrapperBase(String message, boolean success) {
		this.message = message;
		this.success = success;
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

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

}
