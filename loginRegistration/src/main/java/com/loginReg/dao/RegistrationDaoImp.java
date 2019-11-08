package com.loginReg.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.loginReg.model.Registration;

public class RegistrationDaoImp implements RegistrationDao {

	JdbcTemplate jdbcTemplate;

	public RegistrationDaoImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public String save(Registration reg) {
		String qry = "insert into registration(id,name,email,password,gender) values(?,?,?,?,?)";
		try {
			jdbcTemplate.update(qry, reg.getId(), reg.getName(), reg.getEmail(), reg.getPassword(), reg.getGender());
		} catch (Exception e) {
			System.out.println("Email must be unique!");
			return "notUnique";
		}
		return "unique";
	}

	public String emailCheck(String email) {
		String qry = "select email from registration";
		List<?> results = jdbcTemplate.queryForList(qry);
		System.out.println("results" + results);
//		Log.info("results" +results);
		for (Object result : results) {
			Map<?, ?> map = (Map<?, ?>) result;
			for (Object key : map.keySet()) {
				System.out.print(key + "=" + map.get(key) + " , ");
				if (email.equalsIgnoreCase((String) map.get(key))) {
					return "exist";
				}
			}
		}
		return "doesNotExist";
	}
}
