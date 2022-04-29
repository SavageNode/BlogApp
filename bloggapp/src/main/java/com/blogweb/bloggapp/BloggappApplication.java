package com.blogweb.bloggapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.blogweb")
public class BloggappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggappApplication.class, args);
	}

}
