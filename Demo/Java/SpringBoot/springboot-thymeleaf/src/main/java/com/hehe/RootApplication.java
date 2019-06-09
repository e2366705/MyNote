package com.hehe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RootApplication {
	public static void main(String[] args) {
		SpringApplication.run(RootApplication.class, args);
		System.out.println("访问方式:  ");
		System.out.println("http://localhost:8081");
	}
}
