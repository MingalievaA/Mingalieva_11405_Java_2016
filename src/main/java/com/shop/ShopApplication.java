package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {FreeMarkerAutoConfiguration.class})
public class ShopApplication {
	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] {ShopApplication.class}, args);
	}

}
