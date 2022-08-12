package com.example.springbootstudymybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//为什么我不加MapperScan的时候也能调用dao层方法？
@MapperScan("com.example.springbootstudymybatis.dao")
@SpringBootApplication
public class SpringbootStudyMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudyMybatisApplication.class, args);
	}

}
