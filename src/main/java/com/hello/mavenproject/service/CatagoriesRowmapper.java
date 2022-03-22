package com.hello.mavenproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hello.mavenproject.api.Catagories;
public class CatagoriesRowmapper implements RowMapper<Catagories>{

	@Override
	public Catagories mapRow(ResultSet res, int row) throws SQLException {
        Catagories catagories = new Catagories();
		catagories.setCid(res.getInt("cid"));
		catagories.setName(res.getString("name"));
		catagories.setDescription(res.getString("description"));
		return catagories;
	}

}
