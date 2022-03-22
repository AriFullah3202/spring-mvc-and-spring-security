package com.hello.mavenproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hello.mavenproject.api.Post;

public class StudentRowmapper implements RowMapper<Post> {

	@Override
	public Post mapRow(ResultSet rs, int rownum) throws SQLException {
		Post post = new Post();
		post.setPid(rs.getInt("pid"));
		post.setPtitle(rs.getString("ptitle"));
		post.setPcontent(rs.getString("pcontent"));
		return post;
	}

	

}
