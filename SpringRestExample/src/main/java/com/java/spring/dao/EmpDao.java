package com.java.spring.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.java.spring.dto.DsrDto;
import com.java.spring.model.AppDetails;
import com.java.spring.model.AreaDetails;
import com.java.spring.model.CategoryDetails;
import com.java.spring.model.EmployeeDetails;
import com.java.spring.model.NavritiDetails;
import com.java.spring.model.PersonalImage;
import com.java.spring.model.PortalConstantsDetails;
import com.java.spring.model.PortfolioDetails;
import com.java.spring.model.TimesheetDetails;
import com.java.spring.model.UserLogin;

public interface EmpDao {

	EmployeeDetails saveEmpData(EmployeeDetails empData);

	EmployeeDetails fetchEmpData(Long id);

	// void saveUserData(UserLogin userlogin);
	EmployeeDetails fetchLoginData(String username, String userpwd);

	UserLogin getLoginData(String username, String userpwd, boolean isValidUsrName);

	List<AppDetails> getAppDetails();

	List<CategoryDetails> getCategoryDetails();

	List<AreaDetails> getArea();

	void SaveOrUpdateTimesheet(TimesheetDetails timesheetDetails);

	List<DsrDto> getTimeSheetDeatils(Long id);

	PersonalImage saveOrUpdate(PersonalImage personalImage);

	PersonalImage getImage(Long id);

	EmployeeDetails fetchEmpDataByLoginId(UserLogin userLogin);

	void saveOrUpdateObject(Serializable serializable);

	List<NavritiDetails> getIdeaDetailsByUserId(Long empUserId) throws Exception;

	NavritiDetails getIdeaDetailsByIdeaId(Long ideaId) throws Exception;

	List<PortalConstantsDetails> retrieveConstants();

	List<PortfolioDetails> getPortfolios();

	List<AppDetails> getApps(Long id);
}
