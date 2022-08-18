package com.example.springbootstudyjpa.test;

import com.example.springbootstudyjpa.pojo.User;
import com.example.springbootstudyjpa.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class Test01 {
	
	@Resource
	UserService userService;
	
	@Test
	public void test01(){
		//User user = userService.getUserInfo(1);
		userService.deleteUser(20);
		
	}


}
