package com.restaurant.api.dto;

public class PaginationDTO<T> {

	int totalPages;
	long totalElements;
	private T data;

	public PaginationDTO(T data, int totalPages, long totalElements) {
		this.data = data;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

}
