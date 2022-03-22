package com.hello.mavenproject.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalExceptionHandler {
	/*
	 * @ExceptionHandler(value =Exception.class) public String handleException() {
	 * return"Exception"; }
	 */
@ModelAttribute
public String test() {
	
	
	
	return "test";
}

}


