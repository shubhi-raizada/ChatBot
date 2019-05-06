package com.chat;

import static springfox.documentation.builders.PathSelectors.any;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ChatBot {

	
	@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("ChatBot").select()
                .apis(RequestHandlerSelectors.basePackage("com.chat.controller"))
                .paths(any()).build().apiInfo(new ApiInfo("Chat Application",
                        "A set of services to view and send messages for a user", "1.0.0", null,
                        new Contact("Shubhi Raizada", "shubhiraizada.25@gmail.com", null),null, null));
    }
	public static void main(String[] args) {
		SpringApplication.run(ChatBot.class, args);
	}
}
