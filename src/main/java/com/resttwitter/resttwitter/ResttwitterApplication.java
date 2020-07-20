package com.resttwitter.resttwitter;

import com.resttwitter.resttwitter.service.WOEIDService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ResttwitterApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ResttwitterApplication.class, args);

	}

}