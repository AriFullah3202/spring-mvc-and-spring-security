package com.hello.mavenproject.emailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hello.mavenproject.api.UserInfoDTO;
import com.hello.mavenproject.dao.UserDAO;


@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
	private UserDAO userdao;
   // @Autowired
    //private JavaMailSender javaMailSender;    
	
    
    @Override
	public void saveUser(UserInfoDTO userInfodto) {
		/*
		 * SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		 * simpleMailMessage.setTo(userInfodto.getEmail());
		 * simpleMailMessage.setSubject("I am testing an email");
		 * simpleMailMessage.setText("i am new web"+userInfodto.getUserName() +
		 * " devloper for that i am testing");
		 * 
		 * javaMailSender.send(simpleMailMessage);
		 */
    	
    	userdao.saveUser(userInfodto);
	}

}
