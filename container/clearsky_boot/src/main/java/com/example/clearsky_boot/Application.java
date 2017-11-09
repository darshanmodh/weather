package com.example.clearsky_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.clearsky_boot.config.SwaggerConfig;
import com.example.clearsky_boot.config.WebConfig;

@SpringBootApplication
@Import({ WebConfig.class, SwaggerConfig.class })
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
