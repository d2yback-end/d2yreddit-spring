package com.d2y.d2yreddit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class D2yredditApplication {

	public static void main(String[] args) {
		SpringApplication.run(D2yredditApplication.class, args);
	}

}
