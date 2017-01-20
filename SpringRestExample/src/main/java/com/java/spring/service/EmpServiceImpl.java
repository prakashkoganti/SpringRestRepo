package com.java.spring.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.java.spring.constants.PortalConstants;
import com.java.spring.dao.EmpDao;
import com.java.spring.dto.AppDetailsDto;
import com.java.spring.dto.DropDownDto;
import com.java.spring.dto.DsrDto;
import com.java.spring.dto.Emp;
import com.java.spring.dto.NavritiDto;
import com.java.spring.dto.PortfolioDto;
import com.java.spring.model.AppDetails;
import com.java.spring.model.AreaDetails;
import com.java.spring.model.CategoryDetails;
import com.java.spring.model.EmployeeDetails;
import com.java.spring.model.HobbiesDetails;
import com.java.spring.model.NavritiDetails;
import com.java.spring.model.PersonalImage;
import com.java.spring.model.PortalConstantsDetails;
import com.java.spring.model.PortfolioDetails;
import com.java.spring.model.TechnologyDetails;
import com.java.spring.model.TimesheetDetails;
import com.java.spring.model.UserLogin;
import com.java.spring.utils.EmpUtils;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	@Qualifier("empDao")
	private EmpDao empDao;

	public Emp addNewUser(Emp emp) {
		EmployeeDetails empData = new EmployeeDetails();
		if (StringUtils.isNotBlank(emp.getDateOfbirth())) {
			Date date = EmpUtils.convertStringToDate(emp.getDateOfbirth());
			empData.setDateOfbirth(date);
		}
		empData.setAccentureEmailId(emp.getAccentureEmail());
		empData.setPersonalEmailId(emp.getPersonalEmail());
		if (StringUtils.isNotBlank(emp.getSapId())) {
			empData.setId(new Long(emp.getSapId()));
		}
		empData.setMobileNumber(emp.getMobile());
		empData.setProjectName(emp.getProjectName());
		empData.setEmpName(emp.getEmpName());
		empData.setSex(emp.getSex());
		empData.setSapId(emp.getSapId());
		empData.setAboutMe(emp.getAboutMe());
		empData.setHobby(emp.getHobby());
		UserLogin userLogin = new UserLogin();
		userLogin.setUsername(emp.getUsername());
		userLogin.setUserpwd(emp.getPwd());
		userLogin.setUpdatedTimestamp(new Date());
		empData.setUserLogin(userLogin);
		// if(null==emp.getSapId())

		if (null != emp.getEmpId() && 0 != emp.getEmpId()) {
			empData.setId(new Long(emp.getEmpId()));
		} else {
			userLogin.setCreatedTimestamp(new Date());
			empData.setId(new Long(0));
		}
//		Set<HobbiesDetails> hobbiesDetailsList = new HashSet<HobbiesDetails>();
		// HobbiesDetails hobbiesDetails = null;
		// if (null != emp.getHobbies()) {
		// for (String hobbie : emp.getHobbies()) {
		// hobbiesDetails = new HobbiesDetails();
		// hobbiesDetails.setHobbiesDesc(hobbie);
		// hobbiesDetails.setEmployeeDetails(empData);
		// hobbiesDetailsList.add(hobbiesDetails);
		// // empDao.saveOrUpdateObject(hobbiesDetails);
		// }
		// }
		Set<TechnologyDetails> technologyDetailsList = new HashSet<TechnologyDetails>();
		TechnologyDetails technologyDetails = null;
		if (null != emp.getTechnologys()) {
			for (String tech : emp.getTechnologys()) {
				technologyDetails = new TechnologyDetails();
				technologyDetails.setTechnologyDesc(tech);
				technologyDetails.setEmployeeDetails(empData);
				technologyDetailsList.add(technologyDetails);
			}
		}
		empData.setTechnologyDetails(technologyDetailsList);
		// empData.setHobbiesDetails(hobbiesDetailsList);
		AppDetails empAppDetails = new AppDetails();
		empAppDetails.setId(emp.getAppId());
		empData.setEmpAppDetails(empAppDetails);
		empDao.saveEmpData(empData);
		emp.setPwd("");
		return emp;
	}

	public Emp getUser(Long id) {
		Emp emp = new Emp();
		EmployeeDetails empData = empDao.fetchEmpData(id);
		setEmployeeData(empData, emp);
		return emp;
	}

	@Override
	public Emp getLoginUser(Emp emp) {
		Emp returnEmp = new Emp();
		EmployeeDetails employeeDetails = null;
		UserLogin login = empDao.getLoginData(emp.getUsername(), emp.getPwd(), false);
		// EmployeeDetails employeeDetails =
		// empDao.fetchLoginData(emp.getUsername(), emp.getPwd());
		if (null != login) {
			employeeDetails = empDao.fetchEmpDataByLoginId(login);
		}

		if (null != employeeDetails) {
			returnEmp.setUsername(login.getUsername());
			setEmployeeData(employeeDetails, returnEmp);
			returnEmp.setLogin(true);
		}
		return returnEmp;
	}

	@Override
	public DropDownDto getDropDownData() {
		DropDownDto dropDownDto = new DropDownDto();
		@SuppressWarnings("rawtypes")
		List list = empDao.getAppDetails();
		if (null != list) {
			for (Object object : list) {
				AppDetails appDetails = (AppDetails) object;
				dropDownDto.getApplicationsMap().put(appDetails.getId(), appDetails.getAppDesc());
			}
		}
		list = empDao.getCategoryDetails();
		if (null != list) {
			for (Object object : list) {
				CategoryDetails appDetails = (CategoryDetails) object;
				dropDownDto.getCategoryMap().put(appDetails.getId(), appDetails.getCategoryDesc());
			}
		}
		list = empDao.getArea();
		if (null != list) {
			for (Object object : list) {
				AreaDetails appDetails = (AreaDetails) object;
				dropDownDto.getTicketStatusMap().put(appDetails.getId(), appDetails.getAreaDesc());
			}
		}
		return dropDownDto;
	}

	@Override
	public List<DsrDto> getDsrDto(Long id) {

		List<DsrDto> dsrDtosSet = empDao.getTimeSheetDeatils(id);
		return dsrDtosSet;
	}

	@Override
	public DsrDto saveOrUpdate(DsrDto dsrDto) {
		TimesheetDetails timesheetDetails = new TimesheetDetails();
		EmployeeDetails employeeDetails = new EmployeeDetails();
		AppDetails appDetails = new AppDetails();
		appDetails.setId(dsrDto.getAppId());
		CategoryDetails categoryDetails = new CategoryDetails();
		categoryDetails.setId(dsrDto.getCategoryid());
		AreaDetails areaDetails = new AreaDetails();
		areaDetails.setId(dsrDto.getAreaId());
		// employeeDetails.setId(dsrDto.getEmpId());
		if (null != dsrDto.getEmpId() && 0 != dsrDto.getEmpId()) {
			employeeDetails.setId(dsrDto.getEmpId());
		}
		timesheetDetails.setEmployeeDetails(employeeDetails);
		timesheetDetails.setCategoryDetails(categoryDetails);
		timesheetDetails.setAreaDetails(areaDetails);
		timesheetDetails.setAppDetails(appDetails);
		// timesheetDetails.setTicketStatus(ticketStatus);
		if (StringUtils.isNotBlank(dsrDto.getArea())) {
			timesheetDetails.setArea(dsrDto.getArea());
		}
		timesheetDetails.setTimeSheetHours(dsrDto.getWorkHours());
		if (StringUtils.isNotBlank(dsrDto.getTdDate())) {
			timesheetDetails.setTimeSheetDate(EmpUtils.convertDateToString(dsrDto.getTdDate()));
		}
		Calendar cal = Calendar.getInstance();
		if (null != dsrDto.getTimeSheetId() && 0 != dsrDto.getTimeSheetId()) {
			timesheetDetails.setId(dsrDto.getTimeSheetId());
		} else {
			// timesheetDetails.setId(0l);
			timesheetDetails.setCreatedTimestamp(cal.getTime());
		}
		timesheetDetails.setUpdatedTimestamp(cal.getTime());

		empDao.saveOrUpdateObject(timesheetDetails);
		return dsrDto;
	}

	@Override
	public PersonalImage saveOrUpdate(PersonalImage avatar) {
		avatar = empDao.saveOrUpdate(avatar);
		return avatar;
	}

	@Override
	public PersonalImage getImage(Long id) {
		PersonalImage avatar = empDao.getImage(id);
		return avatar;
	}

	private Emp setEmployeeData(EmployeeDetails empData, Emp emp) {
		if (null != empData && null != emp) {
			emp.setEmpId(empData.getId());
			if (StringUtils.isNotBlank(empData.getAccentureEmailId())) {
				emp.setAccentureEmail(empData.getAccentureEmailId());
			}
			if (StringUtils.isNotBlank(empData.getProjectName())) {
				emp.setProjectName(empData.getProjectName());
			}
			if (StringUtils.isNotBlank(empData.getEmpName())) {
				emp.setEmpName(empData.getEmpName());
			}
			if (StringUtils.isNotBlank(empData.getPersonalEmailId())) {
				emp.setPersonalEmail(empData.getPersonalEmailId());
			}
			if (null != empData.getSapId()) {
				emp.setSapId(empData.getSapId().toString());
			}
			if (null != empData.getDateOfbirth()) {
				emp.setDateOfbirth(EmpUtils.convertDateToString(empData.getDateOfbirth()));
			}

			if (StringUtils.isNotBlank(empData.getSex())) {
				emp.setSex(empData.getSex());
			}
			if (StringUtils.isNotBlank(empData.getAboutMe())) {
				emp.setAboutMe(empData.getAboutMe());
			}
			if (StringUtils.isNotBlank(empData.getProjectName())) {
				emp.setProjectName(empData.getProjectName());
			}
			if (null != empData.getTechnologyDetails()) {
				List<String> strings = new ArrayList<String>();
				for (TechnologyDetails tech : empData.getTechnologyDetails()) {
					strings.add(tech.getTechnologyDesc());
				}
				emp.setTechnologys(strings);
			}
			if (null != empData.getHobbiesDetails()) {
				List<String> strings = new ArrayList<String>();
				for (HobbiesDetails hobbiesDetails : empData.getHobbiesDetails()) {
					strings.add(hobbiesDetails.getHobbiesDesc());
				}
				emp.setHobbies(strings);
			}
			if (StringUtils.isNotBlank(empData.getMobileNumber())) {
				emp.setMobile(empData.getMobileNumber());
			}
			if (null != empData.getEmpAppDetails()) {
				emp.setAppId(empData.getEmpAppDetails().getId());
				emp.setAppName(empData.getEmpAppDetails().getAppDesc());
			}

			// emp.setFetchImage(empData.geti);
		}
		return emp;
	}

	@Override
	public boolean validateUserName(String userName) {
		boolean flag = true;
		UserLogin userLogin = empDao.getLoginData(userName, "", true);
		if (null != userLogin) {
			flag = false;
		}
		return flag;
	}

	@Override
	public NavritiDto saveIdea(NavritiDto navritiDto) throws Exception {
		Date date = new Date();
		NavritiDetails navritiDetails = new NavritiDetails();
		navritiDetails.setIdeaId(navritiDto.getIdeaId());
		navritiDetails.setAnnualEffortSavings(navritiDto.getAnnualEffortSavings());
		navritiDetails.setApplicationName(navritiDto.getApplicationName());
		navritiDetails.setClient(navritiDto.getClient());
		navritiDetails.setComments(navritiDto.getComments());
		navritiDetails.setIdeaClassification(navritiDto.getIdeaClassification());
		navritiDetails.setIdeaStage(navritiDto.getIdeaStage());
		navritiDetails.setIdeationDate(date);
		navritiDetails.setPortfolio(navritiDto.getPortfolio());
		navritiDetails.setProblemStatement(navritiDto.getProblemStatement());
		navritiDetails.setEmpId(navritiDto.getEmpId());
		navritiDetails.setSavings(navritiDto.getSavings());
		navritiDetails.setSolutionDescription(navritiDto.getSolutionDescription());
		navritiDetails.setSubmissionDate(date);
		navritiDetails.setSmeReviewedDate(date);
		navritiDetails.setImplementationDate(date);
		navritiDetails.setSubmittedBy(navritiDto.getSubmittedBy());
		navritiDetails.setTechnology(navritiDto.getTechnology());
		empDao.saveOrUpdateObject(navritiDetails);
		return navritiDto;
	}

	@Override
	public List<NavritiDto> getIdeaDetailsByUserId(Long empUserId) throws Exception {
		List<NavritiDto> navritiDtoList = new ArrayList<NavritiDto>();
		List<NavritiDetails> navritiData = empDao.getIdeaDetailsByUserId(empUserId);
		for (NavritiDetails navritiDetails : navritiData) {
			NavritiDto navritiDto = new NavritiDto();
			navritiDto.setAnnualEffortSavings(navritiDetails.getAnnualEffortSavings());
			navritiDto.setApplicationName(navritiDetails.getApplicationName());
			navritiDto.setClientReviewedDate(navritiDetails.getClientReviewedDate());
			navritiDto.setClient(navritiDetails.getClient());
			navritiDto.setComments(navritiDetails.getComments());
			navritiDto.setCouncilReviewedDate(navritiDetails.getCouncilReviewedDate());
			navritiDto.setElapsedTime(navritiDetails.getElapsedTime());
			navritiDto.setEmpId(navritiDetails.getEmpId());
			navritiDto.setIdeaClassification(navritiDetails.getIdeaClassification());
			navritiDto.setIdeaId(navritiDetails.getIdeaId());
			navritiDto.setIdeaStage(navritiDetails.getIdeaStage());
			navritiDto.setIdeationDate(navritiDetails.getIdeationDate());
			navritiDto.setImplementationDate(navritiDetails.getImplementationDate());
			navritiDto.setPerHourDollarRate(navritiDetails.getPerHourDollarRate());
			navritiDto.setPortfolio(navritiDetails.getPortfolio());
			navritiDto.setProblemStatement(navritiDetails.getProblemStatement());
			navritiDto.setSavings(navritiDetails.getSavings());
			navritiDto.setSmeReviewedDate(navritiDetails.getSmeReviewedDate());
			navritiDto.setSolutionDescription(navritiDetails.getSolutionDescription());
			navritiDto.setStageOutCome(navritiDetails.getStageOutCome());
			navritiDto.setSubmissionDate(navritiDetails.getSubmissionDate());
			navritiDto.setSubmittedBy(navritiDetails.getSubmittedBy());
			navritiDto.setTechnology(navritiDetails.getTechnology());
			navritiDtoList.add(navritiDto);
		}
		System.out.println(navritiDtoList);
		return navritiDtoList;
	}

	@Override
	public List<PortalConstants> retrieveConstants() {
		List<PortalConstants> portalConstantsList = new ArrayList<PortalConstants>();
		List<PortalConstantsDetails> portalConstantsDetails = empDao.retrieveConstants();
		if (null != portalConstantsDetails && !portalConstantsDetails.isEmpty()) {
			for (PortalConstantsDetails portalConstant : portalConstantsDetails) {
				PortalConstants portalConstants = new PortalConstants();
				portalConstants.setConstantId(portalConstant.getConstantId());
				portalConstants.setConstantKey(portalConstant.getConstantKey());
				portalConstants.setConstantValue(portalConstant.getConstantValue());
				portalConstantsList.add(portalConstants);
			}
		}
		return portalConstantsList;
	}

	@Override
	public NavritiDto getIdeaDetailsByIdeaId(Long ideaId) throws Exception {
		NavritiDto navritiDto = new NavritiDto();
		NavritiDetails navritiDetails = empDao.getIdeaDetailsByIdeaId(ideaId);
		navritiDto.setAnnualEffortSavings(navritiDetails.getAnnualEffortSavings());
		navritiDto.setApplicationName(navritiDetails.getApplicationName());
		navritiDto.setClientReviewedDate(navritiDetails.getClientReviewedDate());
		navritiDto.setClient(navritiDetails.getClient());
		navritiDto.setComments(navritiDetails.getComments());
		navritiDto.setCouncilReviewedDate(navritiDetails.getCouncilReviewedDate());
		navritiDto.setElapsedTime(navritiDetails.getElapsedTime());
		navritiDto.setEmpId(navritiDetails.getEmpId());
		navritiDto.setIdeaClassification(navritiDetails.getIdeaClassification());
		navritiDto.setIdeaId(navritiDetails.getIdeaId());
		navritiDto.setIdeaStage(navritiDetails.getIdeaStage());
		navritiDto.setIdeationDate(navritiDetails.getIdeationDate());
		navritiDto.setImplementationDate(navritiDetails.getImplementationDate());
		navritiDto.setPerHourDollarRate(navritiDetails.getPerHourDollarRate());
		navritiDto.setPortfolio(navritiDetails.getPortfolio());
		navritiDto.setProblemStatement(navritiDetails.getProblemStatement());
		navritiDto.setSavings(navritiDetails.getSavings());
		navritiDto.setSmeReviewedDate(navritiDetails.getSmeReviewedDate());
		navritiDto.setSolutionDescription(navritiDetails.getSolutionDescription());
		navritiDto.setStageOutCome(navritiDetails.getStageOutCome());
		navritiDto.setSubmissionDate(navritiDetails.getSubmissionDate());
		navritiDto.setSubmittedBy(navritiDetails.getSubmittedBy());
		navritiDto.setTechnology(navritiDetails.getTechnology());
		return navritiDto;
	}

	@Override
	public List<PortfolioDto> getPortfolios() {
		List<PortfolioDto> portfolioDtos = new ArrayList<PortfolioDto>();
		List<PortfolioDetails> list = empDao.getPortfolios();
		PortfolioDto portfolioDto = null;
		for (PortfolioDetails portfolioDetails : list) {
			portfolioDto = new PortfolioDto();
			portfolioDto.setId(portfolioDetails.getId());
			portfolioDto.setPortfolioDesc(portfolioDetails.getPortfolioDesc());
			portfolioDto.setPortfolioMgr(portfolioDetails.getPortfolioMgr());
			portfolioDtos.add(portfolioDto);
		}
		return portfolioDtos;
	}

	@Override
	public List<AppDetailsDto> getApps(Long id) {
		List<AppDetailsDto> appDetailsDtos = new ArrayList<AppDetailsDto>();
		List<AppDetails> appDetailsList = empDao.getApps(id);
		AppDetailsDto appDetailsDto = null;
		for (AppDetails appDetails : appDetailsList) {
			 appDetailsDto = new AppDetailsDto();
			appDetailsDto.setId(appDetails.getId());
			appDetailsDto.setAppDesc(appDetails.getAppDesc());
			appDetailsDtos.add(appDetailsDto);
		}
		return appDetailsDtos;
	}
}
