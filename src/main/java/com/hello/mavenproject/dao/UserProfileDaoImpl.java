package com.hello.mavenproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hello.mavenproject.api.UserInfoDTO;
import com.hello.mavenproject.service.UserInfoDTORowmapper;
@Repository
public class UserProfileDaoImpl implements UserProfileDao {
    
	
	
	  //@Autowired private JdbcTemplate jdbcTemplete;
	 
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	

	@Override
	public UserInfoDTO loadProfie(String name) {
		//System.out.println(name);
		/*
		 * String sql ="SELECT username as userName," + " email as email," +
		 * "firsname as firstName," + " lastname as lastName," +
		 * "  FROM School.users where username ='?'";
		 */
		String sql = "select username, email, firstname, lastname from School.users where username ='"+name+"'";
		
	    System.out.println(sql);
	    System.out.println(name);
	   // UserInfoDTO userInfo =  jdbcTemplete.queryForObject(sql, new UserInfoDTORowmapper(),name);
		
	    UserInfoDTO userInfo =  namedParameterJdbcTemplate.queryForObject(sql, getParameterSource(new UserInfoDTO()), new UserInfoDTORowmapper());
	    return userInfo;
	}
	
    public SqlParameterSource getParameterSource(UserInfoDTO userInfoDTO) {
    	MapSqlParameterSource paramSource = new MapSqlParameterSource();
    	
        if(userInfoDTO != null) {
        	paramSource.addValue("id", userInfoDTO.getId());
    	paramSource.addValue("username", userInfoDTO.getUserName());
    	paramSource.addValue("email", userInfoDTO.getEmail());
    	paramSource.addValue("firstname", userInfoDTO.getFirstName());
    	paramSource.addValue("lastname", userInfoDTO.getLastName());
        }
    	
    	return paramSource;
    }

	

	
}
