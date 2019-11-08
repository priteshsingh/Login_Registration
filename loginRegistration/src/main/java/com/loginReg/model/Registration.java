package com.loginReg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class Registration {
	private int id;
	private String name;
	private String email;
	private String password;
	private String gender;

}
