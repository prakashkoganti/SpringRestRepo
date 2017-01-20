package com.java.spring.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.spring.constants.PortalConstants;
import com.java.spring.constants.URIConstants;
import com.java.spring.dto.AppDetailsDto;
import com.java.spring.dto.DropDownDto;
import com.java.spring.dto.DsrDto;
import com.java.spring.dto.Emp;
import com.java.spring.dto.NavritiDto;
import com.java.spring.dto.PortfolioDto;
import com.java.spring.dto.StatusDto;
import com.java.spring.model.PersonalImage;
import com.java.spring.service.EmpService;
import com.java.spring.utils.ErrorDetails;
import com.java.spring.utils.NavritiErrorDetails;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmpService empService;

	@RequestMapping(value = URIConstants.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody Emp getDummyEmployee() {
		logger.info("Start getDummyEmployee");
		Emp emp = new Emp();
		return emp;
	}

	@RequestMapping(value = URIConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody Emp getEmployee(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID=" + empId);
		return empService.getUser(new Long(empId));
	}

	@RequestMapping(value = URIConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody Emp createEmployee(@RequestBody Emp emp) {
		logger.info("Start createEmployee.");
		if (empService.validateUserName(emp.getUsername())) {
			empService.addNewUser(emp);
		} else {
			emp.setErrorMsg("User Name already exists");
		}
		System.out.println(emp.toString());
		return emp;
	}

	@RequestMapping(value = URIConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody Emp deleteEmployee(@PathVariable("id") int empId) {
		logger.info("Start deleteEmployee.");
		Emp emp = new Emp();
		return emp;
	}

	@RequestMapping(value = URIConstants.AUTH_EMP, method = RequestMethod.POST)
	public @ResponseBody Emp loginEmployee(@RequestBody Emp emp) {
		logger.info("Start deleteEmployee.");
		Emp newemp = empService.getLoginUser(emp);

		if (!newemp.isLogin()) {
			emp.getErrorStatus().setErrorMsg("User Name/ Password worng");
			emp.getErrorStatus().setStatus("failed");
			emp.setErrorMsg("User Name/ Password worng");
		}
		return newemp;
	}

	@RequestMapping(value = URIConstants.TIME_SHEET, method = RequestMethod.POST)
	public @ResponseBody StatusDto createUpdateTimesheet(@RequestBody DsrDto dsrdto) {
		logger.info("Start dsr");
		StatusDto statusDto = new StatusDto();
		try {
			if (null == dsrdto.getEmpId() || 0 == dsrdto.getEmpId()) {
				statusDto.setErrorMsg("Userid is invalid and Failed to update");
			} else {
				statusDto.setErrorMsg("Successfully TimeSheet Created/updated");
			}
			empService.saveOrUpdate(dsrdto);
		} catch (Exception e) {
			statusDto.setErrorMsg("Failed while  Creating /updating TimeSheet");
		}
		return statusDto;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = URIConstants.GET_TIME_SHEET, method = RequestMethod.GET)
	public @ResponseBody List getTimesheet(@PathVariable("id") Long empId) {
		logger.info("Start dsr");
		List dsrdtos = null;
		try {
			dsrdtos = empService.getDsrDto(empId);
		} catch (Exception ex) {
			dsrdtos = new ArrayList();
			StatusDto statusDto = new StatusDto();
			statusDto.setErrorMsg("No data found");
			logger.info(ex.getMessage());
			dsrdtos.add(statusDto);
		}
		return dsrdtos;
	}

	@RequestMapping(value = URIConstants.GET_DROP_DOWNS, method = RequestMethod.GET)
	public @ResponseBody DropDownDto getTimesheet() {
		logger.info("Start dsr");
		DropDownDto dropDownDto = empService.getDropDownData();
		return dropDownDto;
	}

	@RequestMapping(value = URIConstants.FILE_UPLOAD)
	public @ResponseBody Long uploadFile(@RequestParam("file") MultipartFile file) {
		PersonalImage personalImage = new PersonalImage();
		Emp emp = new Emp();
		try {
			personalImage.setImage(file.getBytes());
			personalImage.setImageName(file.getName());
			personalImage = empService.saveOrUpdate(personalImage);
			emp.setDpid(personalImage.getPiId());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return personalImage.getPiId();
	}

	@RequestMapping(value = "/download/{id}")
	public @ResponseBody String downloadFile(@PathVariable("id") int id, HttpServletResponse response,
			HttpServletRequest request) {
		PersonalImage personalImage = new PersonalImage();
		Emp emp = new Emp();
		String base64Encoded = "";
		try {

			FileOutputStream fos = new FileOutputStream("C:/test/output.jpeg");
			personalImage = empService.getImage(new Long(id));
			fos.write(personalImage.getImage());
			fos.close();
			emp.setFetchImage(personalImage.getImage());
			System.out.println(personalImage.getImage().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return base64Encoded;
	}

	@RequestMapping(value = URIConstants.SAVE_IDEA, method = RequestMethod.POST)
	public @ResponseBody ErrorDetails saveIdea(@RequestBody NavritiDto navritiDto) {
		ErrorDetails errorDetails = new ErrorDetails();
		logger.info("Start createEmployee.");
		try {
			empService.saveIdea(navritiDto);
		} catch (DataIntegrityViolationException e) {
			errorDetails.setErrorCode("500");
			errorDetails.setErrorMessage("Invalid Request");
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (Exception e) {
			errorDetails.setErrorCode("500");
			errorDetails.setErrorMessage("Invalid Request");
		}
		errorDetails.setErrorCode("200");
		errorDetails.setErrorMessage("SUCCESS");
		System.out.println(navritiDto.toString());
		return errorDetails;
	}

	@RequestMapping(value = URIConstants.GET_IDEA_DETAILS_BY_USER_ID, method = RequestMethod.GET)
	public @ResponseBody NavritiErrorDetails retrieveIdeaByUserId(@PathVariable("empUserId") Long empUserId) {
		NavritiErrorDetails navritiErrorDetails = new NavritiErrorDetails();
		List<NavritiDto> navritiDto = null;
		try {
			navritiDto = empService.getIdeaDetailsByUserId(empUserId);
			navritiErrorDetails.setNavritiDto(navritiDto);
		} catch (DataIntegrityViolationException e) {
			navritiErrorDetails.setErrorCode("500");
			navritiErrorDetails.setErrorMessage("Invalid Request");
		} catch (Exception e) {
			navritiErrorDetails.setErrorCode("500");
			navritiErrorDetails.setErrorMessage("Invalid Request");
		}
		navritiErrorDetails.setErrorCode("200");
		navritiErrorDetails.setErrorMessage("SUCCESS");
		System.out.println(navritiDto.toString());
		return navritiErrorDetails;
	}

	@RequestMapping(value = URIConstants.GET_IDEA_DETAILS_BY_IDEA_ID, method = RequestMethod.GET)
	public @ResponseBody NavritiDto retrieveIdeaByIdeaId(@PathVariable("ideaId") Long ideaId) {
		NavritiDto navritiDto = null;
		try {
			navritiDto = empService.getIdeaDetailsByIdeaId(ideaId);
		} catch (DataIntegrityViolationException e) {
			navritiDto.setErrorCode("500");
			navritiDto.setErrorMessage("Invalid Request");
		} catch (Exception e) {
			navritiDto.setErrorCode("500");
			navritiDto.setErrorMessage("Invalid Request");
		}
		navritiDto.setErrorCode("200");
		navritiDto.setErrorMessage("SUCCESS");
		System.out.println(navritiDto.toString());
		return navritiDto;
	}

	@RequestMapping(value = URIConstants.GET_PORTAL_CONSTANTS, method = RequestMethod.GET)
	public @ResponseBody ErrorConstantDetails retrieveConstants() {
		ErrorConstantDetails errorDetails = new ErrorConstantDetails();
		List<PortalConstants> portalConstants = null;
		try {
			portalConstants = empService.retrieveConstants();
			errorDetails.setPortalConstants(portalConstants);
		} catch (Exception e) {
			errorDetails.setErrorCode("500");
			errorDetails.setErrorMessage("Invalid Request");
		}
		errorDetails.setErrorCode("200");
		errorDetails.setErrorMessage("SUCCESS");
		System.out.println(portalConstants.toString());
		return errorDetails;
	}

	@RequestMapping(value = URIConstants.GET_PORTFOLIO, method = RequestMethod.GET)
	public @ResponseBody List<PortfolioDto> getPortfolio() {
		return empService.getPortfolios();
	}

	@RequestMapping(value = URIConstants.GET_APPS, method = RequestMethod.GET)
	public @ResponseBody List<AppDetailsDto> getApps(@PathVariable("id") Long id) {
		return empService.getApps(id);
	}
}
