package com.hello.mavenproject.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hello.mavenproject.api.UserInfoDTO;
import com.hello.mavenproject.dao.UserProfileDaoImpl;
@Controller
//@SessionAttributes(value ="userInfo")
public class ProfileController {
	@Autowired
	private UserProfileDaoImpl userProfieDaoImpl;
	
	
	//private Principal principal;
	
	
	
	
	  @ModelAttribute("userInfo") 
	  public UserInfoDTO loadUser(Principal principal)
	  {
	  
	  String changename =principal.getName(); 
	 System.out.println(changename);
	 
      UserInfoDTO userInfoDTO = userProfieDaoImpl.loadProfie(changename);
	  System.out.println(userInfoDTO);
	  return userInfoDTO; 
	  }
	 
	
	@RequestMapping("/myProfile")
   public String showProfile(@ModelAttribute ("userInfo") UserInfoDTO userInDto) {
		System.out.println(userInDto.getFirstName());
		
	   return"profie";
   }
}
