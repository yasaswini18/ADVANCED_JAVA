package com.arcana.BookStoreRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BookStoreRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreRestApiApplication.class, args);
	}

}
