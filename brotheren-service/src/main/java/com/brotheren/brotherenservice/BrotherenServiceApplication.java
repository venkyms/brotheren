package com.brotheren.brotherenservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.brotheren"})
public class BrotherenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrotherenServiceApplication.class, args);
	}
}
