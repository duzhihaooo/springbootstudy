package com.example.springbootstudyjpa.test;

import com.example.springbootstudyjpa.dao.UserRepository;
import com.example.springbootstudyjpa.dao.UsersRepositoryByName;
import com.example.springbootstudyjpa.pojo.User;
import com.example.springbootstudyjpa.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class Test01 {
	
	@Resource
	UserService userService;
	@Resource
	UsersRepositoryByName usersRepositoryByName;
	
	
	@Test
	public void test01(){
		//User user = userService.getUserInfo(1);
		userService.deleteUser(20);
		
	}
	
	@Test
	public void test02(){
		List<User> list = this.usersRepositoryByName.findByUserName("loopy");
		for (User user:list){
			System.out.println(user);
		}
	}


}
