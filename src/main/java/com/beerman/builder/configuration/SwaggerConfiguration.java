package com.beerman.builder.configuration;


import java.util.Collections;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger Configuration
 */
@EnableAutoConfiguration
@Configuration
@EnableSwagger2
public class SwaggerConfiguration
{


	/**
	 * @return instance of Docket for Swagger Configuration
	 */
	@Bean
	public Docket api()
	{	return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.beerman.builder.controller"))
				.build()
				.apiInfo(apiInfo());
	}	//api



	/**
	 * @return ApiInfo that will be used in the instance of the Docket
	 */
	private ApiInfo apiInfo()
	{	String version = "1.0";
		return new ApiInfo(
				"Service Title",
				"Service Description",
				version,
				"",
				new Contact("Beer Man", null, "nocontact@beerman.com"),
				"All Rights Reserved",
				"https://ottawabeerman.com/", Collections.<VendorExtension>emptyList()
				);
	}	//apiInfo


}	//SwaggerConfiguration