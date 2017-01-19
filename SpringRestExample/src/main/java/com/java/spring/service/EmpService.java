package com.java.spring.service;

import java.util.List;
import java.util.Map;

import com.java.spring.constants.PortalConstants;
import com.java.spring.dto.DropDownDto;
import com.java.spring.dto.DsrDto;
import com.java.spring.dto.Emp;
import com.java.spring.dto.NavritiDto;
import com.java.spring.model.PersonalImage;

public interface EmpService {

	Emp addNewUser(Emp emp);

	Emp getUser(Long id);

	Emp getLoginUser(Emp emp);

	DropDownDto getDropDownData();

	List<DsrDto> getDsrDto(Long id);

	DsrDto saveOrUpdate(DsrDto dsrDto);

	PersonalImage saveOrUpdate(PersonalImage personalImage);

	PersonalImage getImage(Long id);

	boolean validateUserName(String userName);

	NavritiDto saveIdea(NavritiDto navritiDto) throws Exception;

	List<NavritiDto> getIdeaDetailsByUserId(Long empUserId) throws Exception;

	NavritiDto getIdeaDetailsByIdeaId(Long empUserId) throws Exception;

	List<PortalConstants> retrieveConstants();
	
	Map<Long,String> getPortfolios();
	Map<Long,String> getApps(Long id);
}
