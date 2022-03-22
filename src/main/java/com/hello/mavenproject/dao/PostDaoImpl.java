package com.hello.mavenproject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.hello.mavenproject.api.Post;
import com.hello.mavenproject.service.PostRowMapper;
import com.hello.mavenproject.service.PostRowMapperByPage;
import com.hello.mavenproject.service.StudentRowmapper;
@Service
public class PostDaoImpl implements PostDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
	@Override
	public List<Post> loadAllPost() {
		
		String sql = "SELECT * FROM post";
		   List<Post> list = jdbcTemplate.query(sql, new PostRowMapper());
		
		return list;
	}

	@Override
	public List<Post> getPostByCatid(int catId) {
		String sql = "SELECT * FROM post WHERE catid =?";
		List<Post> list=jdbcTemplate.query(sql, new StudentRowmapper() , catId);
		return list;
	}

	@Override
	public List<Post> getPostByPage(int pageid, int pageSize) {
		String sql = "SELECT * FROM post LIMIT "+(pageid-1) +"," + pageSize;
		List<Post>  list = jdbcTemplate.query(sql, new PostRowMapperByPage());
		return list;
	}

	

}
