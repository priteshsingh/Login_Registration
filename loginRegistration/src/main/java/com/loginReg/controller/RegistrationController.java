package com.loginReg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loginReg.dao.RegistrationDao;
import com.loginReg.model.Registration;

@Controller
public class RegistrationController {

	@Autowired
	RegistrationDao registrationDao;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(Registration reg) {
		String responseRegisDaoImp = registrationDao.save(reg);
		return responseRegisDaoImp;
	}

	@ResponseBody
	@RequestMapping(value = { "/checkEmail" }, method = RequestMethod.GET)
	public String checkEmail(String email, HttpServletResponse response, HttpServletRequest request) {
		String checkEmail = registrationDao.emailCheck(email);
//		System.out.println("Regis COntroller " + checkEmail);
//		Log.info("Regis COntroller " + checkEmail);
		if (checkEmail.equalsIgnoreCase("exist")) {
			return "exist";
		} else if (checkEmail.equalsIgnoreCase("doesNotExist")) {
			return "doesNotExist";
		} else {
			return "";
		}
	}

	@RequestMapping(value = { "/" })
	public String view() {
		return "test";

	}
}
