package com.pdd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pdd.mapper")
public class PddApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PddApplication.class, args);
	}
	
}
