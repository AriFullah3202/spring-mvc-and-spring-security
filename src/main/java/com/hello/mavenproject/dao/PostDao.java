package com.hello.mavenproject.dao;

import java.util.List;

import com.hello.mavenproject.api.Post;

public interface PostDao {
   public List<Post> loadAllPost();
   public List<Post> getPostByCatid(int catId);
   public List<Post> getPostByPage(int pageid, int pageSize);

}
