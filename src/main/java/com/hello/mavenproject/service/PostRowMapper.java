package com.hello.mavenproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hello.mavenproject.api.Post;

public class PostRowMapper implements RowMapper<Post>{

	@Override
	public Post mapRow(ResultSet res, int row) throws SQLException {
		Post post = new Post();
		post.setPid(res.getInt("pid"));
		post.setPtitle(res.getString("ptitle"));
		post.setPcontent(res.getString("pcontent"));
		post.setCatid(res.getInt("catid"));
		return post;
	}

}
