package com.beerman.builder.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.beerman.builder.controller"})
@ComponentScan(basePackages={"com.beerman.builder.configuration"})
public class BuilderApplication
{	public static void main(String[] args)
	{	SpringApplication.run(BuilderApplication.class, args);
	}	//main

}	//BuilderApplication