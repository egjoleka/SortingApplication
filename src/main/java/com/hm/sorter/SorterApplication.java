package com.hm.sorter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hm.sorter")
public class SorterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SorterApplication.class, args);
	}
}
