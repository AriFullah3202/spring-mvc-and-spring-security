package com.hello.mavenproject.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hello.mavenproject.api.Catagories;
import com.hello.mavenproject.service.CatagoriesRowmapper;



public class CatagoriesDaoimpl implements CatagoriesDao {
    @Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Catagories> loadAllCatagories() {
		
		 String sql = "SELECT * FROM catagories";
		 
		 List<Catagories> listcatagories = jdbcTemplate.query(sql, new CatagoriesRowmapper());
	     
		return listcatagories;
	}
  
}
