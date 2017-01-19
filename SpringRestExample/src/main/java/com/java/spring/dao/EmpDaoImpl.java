package com.java.spring.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
import com.java.spring.utils.EmpUtils;;

@Repository
public class EmpDaoImpl implements EmpDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public EmployeeDetails saveEmpData(EmployeeDetails empData) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(empData);
		} catch (ConstraintViolationException exception) {
			System.out.println(" ia m form " + exception.getConstraintName());
		}

		return empData;
	}

	@Transactional
	public EmployeeDetails fetchEmpData(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		EmployeeDetails returnED = (EmployeeDetails) session.get(EmployeeDetails.class, id);
		returnED.getTechnologyDetails().size();
		returnED.getHobbiesDetails().size();
		// returnED.getTimesheetDetails().size();
		return returnED;
	}

	@Override
	@Transactional
	public List<AppDetails> getAppDetails() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(AppDetails.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public List<CategoryDetails> getCategoryDetails() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CategoryDetails.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public List<AreaDetails> getArea() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(AreaDetails.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public void SaveOrUpdateTimesheet(TimesheetDetails timesheetDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(timesheetDetails);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<DsrDto> getTimeSheetDeatils(Long id) {
		Set<TimesheetDetails> timeSheetDetailsSet = null;
		Session session = this.sessionFactory.getCurrentSession();
		EmployeeDetails employeeDetails = (EmployeeDetails) session.load(EmployeeDetails.class, id);
		timeSheetDetailsSet = employeeDetails.getTimesheetDetails();
		List<DsrDto> dsrDtosSet = new ArrayList<DsrDto>();
		DsrDto dsrDto = new DsrDto();
		for (TimesheetDetails timesheetDetails : timeSheetDetailsSet) {
			dsrDto = new DsrDto();
			AppDetails appDetails = timesheetDetails.getAppDetails();
			CategoryDetails categoryDetails = timesheetDetails.getCategoryDetails();
			AreaDetails areaDetails = timesheetDetails.getAreaDetails();
			dsrDto.setEmpId(id);
			if (null != appDetails) {
				dsrDto.setApplicationName(appDetails.getAppDesc());
				dsrDto.setAppId(appDetails.getId());
			}
			if (null != categoryDetails) {
				dsrDto.setCategoryName(categoryDetails.getCategoryDesc());
				dsrDto.setCategoryid(categoryDetails.getId());
			}
			if (null != areaDetails) {
				dsrDto.setAreaDesc(areaDetails.getAreaDesc());
				dsrDto.setAreaId(areaDetails.getId());
			}
			dsrDto.setArea(timesheetDetails.getArea());
			dsrDto.setDate(EmpUtils.convertDateToString(timesheetDetails.getTimeSheetDate()));
			dsrDto.setTaskDesc(timesheetDetails.getTaskDesc());
			dsrDto.setWorkHours(timesheetDetails.getTimeSheetHours());
			dsrDto.setTimeSheetId(timesheetDetails.getId());
			dsrDtosSet.add(dsrDto);
		}
		return dsrDtosSet;
	}

	@Override
	@Transactional
	public PersonalImage saveOrUpdate(PersonalImage avatar) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(avatar);
		return avatar;
	}

	@Override
	@Transactional
	public PersonalImage getImage(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		PersonalImage returnED = (PersonalImage) session.get(PersonalImage.class, id);
		return returnED;
	}

	@Override
	@Transactional
	public void saveOrUpdateObject(Serializable serializable) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(serializable);
	}

	@Transactional
	public EmployeeDetails fetchLoginData(String username, String userpwd) {
		EmployeeDetails employeeDetails = null;
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeDetails.class);
		criteria.add(Restrictions.eq("username", username));
		if (StringUtils.isNotBlank(userpwd)) {
			criteria.add(Restrictions.eq("userpwd", userpwd));
		}
		List list = criteria.list();
		if (null != list && !list.isEmpty()) {
			employeeDetails = (EmployeeDetails) list.get(0);
		}
		if (null != employeeDetails) {
			if (null != employeeDetails.getHobbiesDetails()) {
				employeeDetails.getHobbiesDetails().size();
			}
			if (null != employeeDetails.getTechnologyDetails()) {
				employeeDetails.getTechnologyDetails().size();
			}
		}
		return employeeDetails;
	}

	@Override
	@Transactional
	public UserLogin getLoginData(String username, String userpwd, boolean isValidUsrName) {
		UserLogin userLogin = null;
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserLogin.class);
		criteria.add(Restrictions.eq("username", username));
		if (!isValidUsrName) {
			criteria.add(Restrictions.eq("userpwd", userpwd));
		}
		List list = criteria.list();
		if (null != list && !list.isEmpty()) {
			userLogin = (UserLogin) list.get(0);
		}
		return userLogin;
	}

	@Transactional
	public EmployeeDetails fetchEmpDataByLoginId(UserLogin userLogin) {
		EmployeeDetails employeeDetails = new EmployeeDetails();
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(EmployeeDetails.class);
		criteria.add(Restrictions.eq("userLogin", userLogin));
		List list = criteria.list();
		if (null != list && !list.isEmpty()) {
			employeeDetails = (EmployeeDetails) list.get(0);
		}
		if (null != employeeDetails) {
			if (null != employeeDetails.getHobbiesDetails()) {
				employeeDetails.getHobbiesDetails().size();
			}
			if (null != employeeDetails.getTechnologyDetails()) {
				employeeDetails.getTechnologyDetails().size();
			}
			if (null != employeeDetails.getEmpAppDetails()) {
				employeeDetails.getEmpAppDetails();
			}
		}
		return employeeDetails;
	}

	@Override
	@Transactional
	public List<NavritiDetails> getIdeaDetailsByUserId(Long empUserId) throws Exception {
		List<NavritiDetails> navritiData = null;
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(NavritiDetails.class);
		crit.add(Restrictions.eq("sapId", empUserId));
		if (null != crit.list() && !crit.list().isEmpty()) {
			navritiData = (List<NavritiDetails>) crit.list();
		}
		System.out.println("navritiData : " + navritiData);
		return navritiData;
	}

	@Override
	@Transactional
	public NavritiDetails getIdeaDetailsByIdeaId(Long empUserId) throws Exception {
		NavritiDetails navritiDetails = null;
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(NavritiDetails.class);
		crit.add(Restrictions.eq("ideaId", empUserId));
		if (null != crit.list() && !crit.list().isEmpty()) {
			navritiDetails = (NavritiDetails) crit.list().get(0);
		}
		System.out.println("navritiData : " + navritiDetails);
		return navritiDetails;
	}

	@Override
	@Transactional
	public List<PortalConstantsDetails> retrieveConstants() {
		List<PortalConstantsDetails> portalConstantsDetails = null;
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(PortalConstantsDetails.class);
		// if(null != crit.list() && !crit.list().isEmpty()){
		portalConstantsDetails = crit.list();
		// }
		// System.out.println(portalConstantsDetails);
		return portalConstantsDetails;
	}

	@Override
	@Transactional
	public List<PortfolioDetails> getPortfolios() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PortfolioDetails.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public List<AppDetails> getApps(Long id) {
		PortfolioDetails portfolioDetails = new PortfolioDetails();
		portfolioDetails.setId(id);
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(AppDetails.class);
		criteria.add(Restrictions.eq("portfolioDetails", portfolioDetails));
		return criteria.list();
	}
}
