package com.yk.common;

/**
 * 리스트 검색 공통
 * 
 * @author ykkim
 * 
 */
public class Search {
	private int start; // 페이징 시작값
	private int limit; // 페이징 카운트
	private int page;
	private String searchColumn; // 검색시 사용되는 컬럼명
	private String searchText; // 검색어
	private String startDate; // 시작일
	private String endDate; // 종료일

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getSearchColumn() {
		return searchColumn;
	}

	public void setSearchColumn(String searchColumn) {
		this.searchColumn = searchColumn;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
