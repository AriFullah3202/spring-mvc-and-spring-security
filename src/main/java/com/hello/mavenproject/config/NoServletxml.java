package com.hello.mavenproject.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.hello.mavenproject.dao.CatagoriesDaoimpl;
import com.hello.mavenproject.dao.PostDaoImpl;
import com.hello.mavenproject.dao.UserDAO;
import com.hello.mavenproject.dao.UserDaoImpl;
import com.hello.mavenproject.dao.UserProfileDaoImpl;
import com.hello.mavenproject.emailService.EmailService;
import com.hello.mavenproject.emailService.EmailServiceImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.hello.mavenproject.controller")
@PropertySource("classpath:email.properties")
public class NoServletxml implements WebMvcConfigurer{
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		return jdbcTemplate;
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/School");
		dataSource.setUsername("root");
		dataSource.setPassword("arif12345678arif");

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		return dataSource;

	}

	@Bean
	public CatagoriesDaoimpl catagories() {
		CatagoriesDaoimpl catagoriesImpl = new CatagoriesDaoimpl();
		return catagoriesImpl;
	}
	@Bean
	public PostDaoImpl post() {
		PostDaoImpl postDaoImpl = new PostDaoImpl();
		return postDaoImpl;
	
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	    .addResourceHandler("/UrlToResourceFolder/**")
	    .addResourceLocations("/resources/");
	    
	    
	}
	
	
	
	 @Bean public PasswordEncoder getPasswordEncoder() { 
		  return new BCryptPasswordEncoder(); }
	 
	 
	 

	/*
	 * @Bean public BCryptPasswordEncoder gettPasswordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	
	  //bean creating for EmailServiceimp
	
	  @Bean public EmailService getEmailService() { EmailServiceImpl
	  emailServiceImpl = new EmailServiceImpl(); return emailServiceImpl; }
	 
	 @Bean
	  public UserDAO getUserDao() {
		  UserDaoImpl userDaoImpl = new UserDaoImpl();
		  return userDaoImpl;
	  }
	 @Bean
	public JavaMailSender configureJavaMailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		 javaMailSenderImpl.setHost("");
		 javaMailSenderImpl.setUsername("");
		 javaMailSenderImpl.setPassword("");
		 javaMailSenderImpl.setPort(3);
		 
		 Properties properties = new Properties();
		 properties.put("key", "value");
		 properties.put("key", "value");
		 javaMailSenderImpl.setJavaMailProperties(properties);
		
		
		return javaMailSenderImpl;
	 }
	 @Bean
	 public UserProfileDaoImpl getUserProfile() {
		 UserProfileDaoImpl userProfile =new UserProfileDaoImpl();
		 
		 return userProfile;
	 }
	 @Bean
	 public NamedParameterJdbcTemplate getjdbc() {
		 NamedParameterJdbcTemplate name = new NamedParameterJdbcTemplate(getDataSource());
	 return name;
	 
	 }
	 
		
	  
	 
}
