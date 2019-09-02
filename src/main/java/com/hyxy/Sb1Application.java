package com.hyxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hyxy.*"})
@MapperScan("com.hyxy.dao")
public class Sb1Application {  

	public static void main(String[] args) {
		SpringApplication.run(Sb1Application.class, args);
	}
    
}
