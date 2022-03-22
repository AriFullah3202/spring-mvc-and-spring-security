package com.hello.mavenproject.controller;

import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hello.mavenproject.api.UserInfoDTO;
import com.hello.mavenproject.emailService.EmailService;
@Controller
public class UserController {
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private EmailService emailService;
	
    @RequestMapping("/LogIn")
	public String doCustumLogIn() {
	  
	  
	  return"log-in";
  }
   

   
    @GetMapping("/signUp")
   public String doSignUp(@ModelAttribute("UserInfo") UserInfoDTO userInfodto) {
    	
    	
	   return "sign-up";
   }
    @PostMapping("/process-signup")
    public String processSign(@Valid@ModelAttribute("UserInfo") UserInfoDTO userInfodto , BindingResult result) {
    	String password = passwordEncoder.encode(userInfodto.getPassword());
    	userInfodto.setPassword(password);
    	//write a logic for sign up
    	System.out.println(userInfodto);
    	if(result.hasErrors()) {
			System.out.println("my page has error");
			List<ObjectError> allErrors = result.getAllErrors();			
			for(ObjectError error : allErrors) {
				System.out.println(error);
				
			}
    	   return "sign-up";
    	}
    	
    	
    	
    	emailService.saveUser(userInfodto);
    	return"redirect:/LogIn";
    }
    
    
}
