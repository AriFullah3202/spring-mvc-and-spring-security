package com.hello.mavenproject.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {
			MySecurityConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class arr[] = {NoServletxml.class};
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String arr[] = {"/"};
		return arr;
	}
}
