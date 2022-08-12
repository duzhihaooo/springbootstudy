package com.example.springbootstudymybatis;

import com.example.springbootstudymybatis.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootStudyMybatisApplicationTests {
	
	@Autowired
	UserDao userDao;
	
	@Test
	void contextLoads() {
	
	}

}
