package com.example.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/example/study/mapper")
public class SpringbootStudyMybatisPlusApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudyMybatisPlusApplication.class, args);
	}
	
}
