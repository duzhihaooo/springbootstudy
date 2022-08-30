package com.example.study.test;

import com.example.study.demo.Role;
import com.example.study.demo.User;
import com.example.study.mapper.RoleMapper;
import com.example.study.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class test01 {
	
	@Autowired
	UserMapper userMapper;
	@Autowired
	RoleMapper roleMapper;
	
	
	@Test
	public void test01(){
		User user = new User();
		user.setUserName("EpikHigh");
		userMapper.insert(user);
		System.out.println(user.getId());
	}
	
	@Test
	public  void test02(){
		Role role = new Role();
		role.setRoleName("journalist");
		roleMapper.insert(role);
		System.out.println(role.getId());
	}
	
	
}
