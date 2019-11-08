package com.loginReg.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDaoImp implements LoginDao {

	JdbcTemplate jdbcTemplate;

	public LoginDaoImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@SuppressWarnings("rawtypes")
	public int emailValid(String email, String password) {
		// query for getting record from customer table using email and password
		String query = "select * from registration where (email= '" + email + "' and password='" + password + "')";
//				System.out.println(query.toString()+ " Pritesh");

		List results = jdbcTemplate.queryForList(query);

		System.out.println("email Validation for login" + results.size());
//				Log.info("email Validation for login" +results.size());

		// if size of list is greater than 0 then returning 1 --'INDICATES success'
		if (results.size() > 0) {
			return 1;
		}

		// failure
		return 0;
	}

}
