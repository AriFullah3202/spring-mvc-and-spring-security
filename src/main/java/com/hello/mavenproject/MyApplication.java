package com.hello.mavenproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration

public class MyApplication {

	public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext();
      
	}

}
