package com.example.blog.config;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.lang.Collections;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class CustomizeSwagger {                  //TO customize the default message shown on swagger ui

	@Bean
	public Docket customize()
	{
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo()).select()
				.apis(RequestHandlerSelectors.any()) // all requests
				.paths(PathSelectors.any()) // any paths 
				.build();
	}
	
	// WE provide info about our application to be displayed on swagger
	private ApiInfo getInfo() {  
		// TODO Auto-generated method stub
		return new ApiInfo("Blogging Application - Backend","This project is developed for learning purpose", 
				"1.0", "Terms of Service", new Contact("Samir","https://github.com/samir937/Blogers","samirpattanaik14@gmail.com"),
				"License of APIs" ,"API License Url",java.util.Collections.emptyList());
	}
}
