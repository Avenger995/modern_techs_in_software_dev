package com.example.footballers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FootballersApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballersApplication.class, args);
	}
}
