package com.hello.mavenproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hello.mavenproject.api.Catagories;
import com.hello.mavenproject.api.Post;
import com.hello.mavenproject.dao.CatagoriesDao;
import com.hello.mavenproject.dao.PostDao;
@Controller

//@SessionAttributes(value = {"catagories"})
@ControllerAdvice
public class CatagoriesController {
	
	@Autowired
	private CatagoriesDao catagoriesDao;
	@Autowired
	private PostDao postDao;
	
	
	  @ModelAttribute("catagories") public List<Catagories> createModel() {
	  List<Catagories> AlllistCatagories = catagoriesDao.loadAllCatagories();
	  return AlllistCatagories; }
	 
	
	
	@RequestMapping("/")
   public String showCateagories(Model model, Model model1) {
		
	   List<Catagories> AlllistCatagories = catagoriesDao.loadAllCatagories();
	  
	   model.addAttribute("catagories", AlllistCatagories);
	   List<Post> showPosts = postDao.loadAllPost();
	  
	   model.addAttribute("posts", showPosts);
	  
	   return "home";
   }
	
}
