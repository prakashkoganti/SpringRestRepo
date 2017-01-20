package com.java.spring.dto;

public class PortfolioDto {
	
	private Long id;

	private String portfolioDesc;

	private String portfolioMgr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPortfolioDesc() {
		return portfolioDesc;
	}

	public void setPortfolioDesc(String portfolioDesc) {
		this.portfolioDesc = portfolioDesc;
	}

	public String getPortfolioMgr() {
		return portfolioMgr;
	}

	public void setPortfolioMgr(String portfolioMgr) {
		this.portfolioMgr = portfolioMgr;
	}
}
