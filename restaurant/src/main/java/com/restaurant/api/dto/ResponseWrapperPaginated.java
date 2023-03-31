package com.restaurant.api.dto;

public class ResponseWrapperPaginated<T> extends ResponseWrapper<T> {

	int totalPages;
	long totalElements;

	public ResponseWrapperPaginated(T data, int totalPages, long totalElements) {
		super(data);
		this.totalPages = totalPages;
		this.totalElements = totalElements;
	}

	public ResponseWrapperPaginated(PaginationDTO<T> paginationDTO) {
		super(paginationDTO.getData());
		this.totalPages = paginationDTO.getTotalPages();
		this.totalElements = paginationDTO.getTotalElements();
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
