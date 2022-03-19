package com.beerman.builder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Home Controller
 */
@RestController
public class HomeController
{	/**
	 * @return test end
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String testHello()
	{	return "Hello World";
	}	//testHello
}	//HomeController