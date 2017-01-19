package com.java.spring.dto;

import java.util.HashMap;
import java.util.Map;

public class DropDownDto {

	private Map<Long, String> applicationsMap = new HashMap<Long, String>();
	private Map<Long, String> ticketStatusMap = new HashMap<Long, String>();
	private Map<Long, String> categoryMap = new HashMap<Long, String>();

	public Map<Long, String> getApplicationsMap() {
		return applicationsMap;
	}

	public void setApplicationsMap(Map<Long, String> applicationsMap) {
		this.applicationsMap = applicationsMap;
	}

	public Map<Long, String> getTicketStatusMap() {
		return ticketStatusMap;
	}

	public void setTicketStatusMap(Map<Long, String> ticketStatusMap) {
		this.ticketStatusMap = ticketStatusMap;
	}

	public Map<Long, String> getCategoryMap() {
		return categoryMap;
	}

	public void setCategoryMap(Map<Long, String> categoryMap) {
		this.categoryMap = categoryMap;
	}

}
