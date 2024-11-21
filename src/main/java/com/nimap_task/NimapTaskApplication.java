package com.nimap_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.nimap_task.entity")
public class NimapTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(NimapTaskApplication.class, args);
	}

}
