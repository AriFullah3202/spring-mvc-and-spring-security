package com.hello.mavenproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hello.mavenproject.api.UserInfoDTO;

public class UserInfoDTORowmapper implements RowMapper<UserInfoDTO> {

	@Override
	public UserInfoDTO mapRow(ResultSet res, int row) throws SQLException {
		UserInfoDTO userInfoDTO =new UserInfoDTO();
		//userInfoDTO.setId(res.getInt("id"));
		userInfoDTO.setUserName(res.getString("username"));
		userInfoDTO.setEmail(res.getString("email"));
		userInfoDTO.setFirstName(res.getString("firstname"));
		userInfoDTO.setLastName(res.getString("lastname"));
		return userInfoDTO;
	}

}
