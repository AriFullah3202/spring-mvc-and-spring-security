package com.hello.mavenproject.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
   
	@Autowired
	private DataSource dataSouce;
    
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.jdbcAuthentication().dataSource(dataSouce).passwordEncoder(new BCryptPasswordEncoder())
;
		//System.out.println("my password is " + bcryptPasswordEncoder.encode("arif3355"));
	}

	
	  @Override 
	protected void configure(HttpSecurity http) throws Exception { 
	http
	  .authorizeRequests() 
				
		.antMatchers("/")
	  .authenticated()
	  .antMatchers("/about")
				 
	  
	  .authenticated()
	  
	  .and()
	  .formLogin().loginPage("/LogIn").loginProcessingUrl("/process-login").permitAll()
	  .and() 
	  .httpBasic()
	  .and()
	  .logout();
	}
	 

	
	/*
	 * @Bean public PasswordEncoder getPasswordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */
	
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
	  
	 

}