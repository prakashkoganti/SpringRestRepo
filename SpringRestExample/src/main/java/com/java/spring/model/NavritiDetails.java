package com.java.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "navriti_details")
public class NavritiDetails implements Serializable {

	private static final long serialVersionUID = -3395067890881712084L;

	@Id
	@Column(name = "idea_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ideaId;

	@Column(name = "emp_user_id")
	private Long empId;
	
	@Column(name = "idea_stage")
	private String ideaStage;

	@Column(name = "stage_outcome")
	private String stageOutCome;
	
	@Column(name = "submission_date")
	private Date SubmissionDate;
	
	@Column(name = "portfolio")
	private String portfolio;

	@Column(name = "application_name")
	private String applicationName;

	@Column(name = "submitted_by")
	private String submittedBy;

	@Column(name = "idea_classification")
	private String ideaClassification;

	@Column(name = "problem_statement")
	private String problemStatement;
	
	@Column(name = "solution_description")
	private String solutionDescription;

	@Column(name = "ideation_date")
	private Date ideationDate;
	
	@Column(name = "per_hour_dollar_rate")
	private Long perHourDollarRate;
	
	@Column(name = "annual_effort_savings")
	private Long annualEffortSavings;
	
	@Column(name = "sme_review_date")
	private Date smeReviewedDate;
	
	@Column(name = "council_review_date")
	private Date councilReviewedDate;
	
	@Column(name = "client_review_date")
	private Date clientReviewedDate;
	
	@Column(name = "implementation_date")
	private Date implementationDate;
	
	@Column(name = "savings")
	private Long savings;
	
	@Column(name = "elapsed_time")
	private int elapsedTime;
	
	@Column(name = "client")
	private String client;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "technology")
	private String technology;

	/**
	 * @return the ideaId
	 */
	public Long getIdeaId() {
		return ideaId;
	}

	/**
	 * @param ideaId the ideaId to set
	 */
	public void setIdeaId(Long ideaId) {
		this.ideaId = ideaId;
	}

	/**
	 * @return the ideaStage
	 */
	public String getIdeaStage() {
		return ideaStage;
	}

	/**
	 * @param ideaStage the ideaStage to set
	 */
	public void setIdeaStage(String ideaStage) {
		this.ideaStage = ideaStage;
	}

	/**
	 * @return the stageOutCome
	 */
	public String getStageOutCome() {
		return stageOutCome;
	}

	/**
	 * @param stageOutCome the stageOutCome to set
	 */
	public void setStageOutCome(String stageOutCome) {
		this.stageOutCome = stageOutCome;
	}

	/**
	 * @return the submissionDate
	 */
	public Date getSubmissionDate() {
		return SubmissionDate;
	}

	/**
	 * @param submissionDate the submissionDate to set
	 */
	public void setSubmissionDate(Date submissionDate) {
		SubmissionDate = submissionDate;
	}

	/**
	 * @return the portfolio
	 */
	public String getPortfolio() {
		return portfolio;
	}

	/**
	 * @param portfolio the portfolio to set
	 */
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	/**
	 * @return the applicationName
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * @param applicationName the applicationName to set
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	/**
	 * @return the submittedBy
	 */
	public String getSubmittedBy() {
		return submittedBy;
	}

	/**
	 * @param submittedBy the submittedBy to set
	 */
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	/**
	 * @return the ideaClassification
	 */
	public String getIdeaClassification() {
		return ideaClassification;
	}

	/**
	 * @param ideaClassification the ideaClassification to set
	 */
	public void setIdeaClassification(String ideaClassification) {
		this.ideaClassification = ideaClassification;
	}

	/**
	 * @return the problemStatement
	 */
	public String getProblemStatement() {
		return problemStatement;
	}

	/**
	 * @param problemStatement the problemStatement to set
	 */
	public void setProblemStatement(String problemStatement) {
		this.problemStatement = problemStatement;
	}

	/**
	 * @return the solutionDescription
	 */
	public String getSolutionDescription() {
		return solutionDescription;
	}

	/**
	 * @param solutionDescription the solutionDescription to set
	 */
	public void setSolutionDescription(String solutionDescription) {
		this.solutionDescription = solutionDescription;
	}

	/**
	 * @return the ideationDate
	 */
	public Date getIdeationDate() {
		return ideationDate;
	}

	/**
	 * @param ideationDate the ideationDate to set
	 */
	public void setIdeationDate(Date ideationDate) {
		this.ideationDate = ideationDate;
	}

	/**
	 * @return the perHourDollarRate
	 */
	public Long getPerHourDollarRate() {
		return perHourDollarRate;
	}

	/**
	 * @param perHourDollarRate the perHourDollarRate to set
	 */
	public void setPerHourDollarRate(Long perHourDollarRate) {
		this.perHourDollarRate = perHourDollarRate;
	}

	/**
	 * @return the annualEffortSavings
	 */
	public Long getAnnualEffortSavings() {
		return annualEffortSavings;
	}

	/**
	 * @param annualEffortSavings the annualEffortSavings to set
	 */
	public void setAnnualEffortSavings(Long annualEffortSavings) {
		this.annualEffortSavings = annualEffortSavings;
	}

	/**
	 * @return the smeReviewedDate
	 */
	public Date getSmeReviewedDate() {
		return smeReviewedDate;
	}

	/**
	 * @param smeReviewedDate the smeReviewedDate to set
	 */
	public void setSmeReviewedDate(Date smeReviewedDate) {
		this.smeReviewedDate = smeReviewedDate;
	}

	/**
	 * @return the councilReviewedDate
	 */
	public Date getCouncilReviewedDate() {
		return councilReviewedDate;
	}

	/**
	 * @param councilReviewedDate the councilReviewedDate to set
	 */
	public void setCouncilReviewedDate(Date councilReviewedDate) {
		this.councilReviewedDate = councilReviewedDate;
	}

	/**
	 * @return the clientReviewedDate
	 */
	public Date getClientReviewedDate() {
		return clientReviewedDate;
	}

	/**
	 * @param clientReviewedDate the clientReviewedDate to set
	 */
	public void setClientReviewedDate(Date clientReviewedDate) {
		this.clientReviewedDate = clientReviewedDate;
	}

	/**
	 * @return the implementationDate
	 */
	public Date getImplementationDate() {
		return implementationDate;
	}

	/**
	 * @param implementationDate the implementationDate to set
	 */
	public void setImplementationDate(Date implementationDate) {
		this.implementationDate = implementationDate;
	}

	/**
	 * @return the savings
	 */
	public Long getSavings() {
		return savings;
	}

	/**
	 * @param savings the savings to set
	 */
	public void setSavings(Long savings) {
		this.savings = savings;
	}

	/**
	 * @return the elapsedTime
	 */
	public int getElapsedTime() {
		return elapsedTime;
	}

	/**
	 * @param elapsedTime the elapsedTime to set
	 */
	public void setElapsedTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}

	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

}