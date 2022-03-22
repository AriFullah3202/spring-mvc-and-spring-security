package com.hello.mavenproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.mavenproject.api.Post;
import com.hello.mavenproject.dao.PostDao;

@Controller
public class PostController {
	@Autowired
	private PostDao postdao;

  public String doPost(){
	  
	  return "doPost";
  }
	@RequestMapping("{pageid}")
  public String AllPost(@PathVariable int pageid ,Model model) {
		System.out.println(pageid);
		
		List<Post> allPostbyCatId = postdao.getPostByCatid(pageid);
		model.addAttribute("allpostbyCatid", allPostbyCatId);
		
		//model.getAttribute("catagories");
	  return"home";
  }
	
	@RequestMapping("/viewPost/{pageid}")
	public String viewPostByPage(@PathVariable int pageid, Model model1) {
		int pageSize = 2;
		if(pageid == 1) {
			
		} 
			  else { 
				  pageid = (pageid -1) * pageSize+1;
				  }
			 
		
		List<Post> viewPostbyPage = postdao.getPostByPage(pageid, pageSize);
		model1.addAttribute("msg", viewPostbyPage);
		return "home";
	}
	@RequestMapping("/getCatid/")
	public String getCatid(@RequestParam("cid") String catid) {
		System.out.println(catid);
		return "index";
	}
}
