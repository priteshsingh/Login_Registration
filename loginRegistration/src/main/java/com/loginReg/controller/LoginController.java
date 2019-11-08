package com.loginReg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.loginReg.dao.LoginDao;
import com.loginReg.model.Login;
import com.loginReg.model.Registration;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Log4j2
@Controller
public class LoginController {
	@Autowired
	LoginDao loginDao;

	@ResponseBody
	@RequestMapping(value = { "/validLoginEmail" }, method = RequestMethod.POST)
	public String checkEmail(String email, String password) {
		int response = loginDao.emailValid(email, password);
		System.out.println("login COntroller " + response);
		log.info("login COntroller " + response);
		if (response == 1) {
			return "success";
		} else {
			return " ";
		}
	}
	
	
}
