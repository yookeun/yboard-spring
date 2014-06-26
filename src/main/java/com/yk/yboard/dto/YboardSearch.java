package com.yk.yboard.dto;

import com.yk.common.Search;

public class YboardSearch extends Search {
	private int priority; // : 우선순위

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
