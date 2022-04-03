package com.beerman.builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.beerman.builder.controller"})
@ComponentScan(basePackages={"com.beerman.builder.configuration"})
@ComponentScan(basePackages={"com.beerman.builder.repository"})
@ComponentScan(basePackages={"com.beerman.builder.service"})
public class BuilderApplication
{	public static void main(String[] args)
	{	SpringApplication.run(BuilderApplication.class, args);
	}	//main

}	//BuilderApplication