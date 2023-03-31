package com.restaurant.api.dto;

public class ResponseWrapper<T> extends ResponseWrapperBase<T> {

	private T data;	
    
    public ResponseWrapper(T data) {
		super();
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
