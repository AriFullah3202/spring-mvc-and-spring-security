package com.hello.mavenproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.mavenproject.api.Offer;
import com.hello.mavenproject.dao.OfferDao;


@RestController
@RequestMapping("offer")
public class OfferController {
	/*
	 * @Autowired public OfferDao offerdao;
	 */
	
    @RequestMapping("/allOffer")
	public String showOffer(@ModelAttribute("offer") Offer offer)  

{
	   
	   return null;
   }
}
