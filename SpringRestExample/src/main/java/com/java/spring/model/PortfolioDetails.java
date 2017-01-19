package com.java.spring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio_details")
public class PortfolioDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6341332111713112456L;

	@Id
	@Column(name = "portfolio_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "portfolio_desc")
	private String portfolioDesc;
	
	@Column(name = "portfolio_mgr")
	private String portfolioMgr;
	
	@OneToMany(mappedBy="portfolioDetails",cascade=CascadeType.ALL)
	private Set<AppDetails> appDetails;

	public PortfolioDetails() {

	}

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

	public Set<AppDetails> getAppDetails() {
		return appDetails;
	}

	public void setAppDetails(Set<AppDetails> appDetails) {
		this.appDetails = appDetails;
	}


}