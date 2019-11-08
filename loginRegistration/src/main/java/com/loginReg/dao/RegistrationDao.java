package com.loginReg.dao;

import com.loginReg.model.Registration;

public interface RegistrationDao {
	public String save(Registration reg);
	
	public String emailCheck(String email);

}
