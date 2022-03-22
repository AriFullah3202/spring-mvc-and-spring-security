package com.hello.mavenproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hello.mavenproject.api.UserInfoDTO;


@Repository
public class UserDaoImpl implements UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void saveUser(UserInfoDTO userInfodto) {
		String sql ="INSERT INTO users values(?,?,?,?,?,?)";
		String sql2 ="INSERT INTO authorities values(?,?)";
		jdbcTemplate.update(sql, userInfodto.getUserName(), userInfodto.getPassword(), userInfodto.getEmail(), userInfodto.getFirstName(), userInfodto.getLastName(),1);
		jdbcTemplate.update(sql2, userInfodto.getUserName(),"ADMIN");
	}

}
