package com.example.study.test;

import com.example.study.demo.Role;
import com.example.study.demo.User;
import com.example.study.mapper.RoleMapper;
import com.example.study.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.XMLFormatter;
import java.util.stream.Collectors;

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
	
	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("Hello","World");
		final String collect = list1.stream()
				//[H,e,l,l,o]
				.map(x -> x.toCharArray())
				//{H,e,l,l,o}
				.map(x -> {
					List<String> list = new ArrayList<>();
					for (final char c : x) {
						list.add(String.valueOf(c));
						
					}
					
					return list;
				})
				.flatMap(x -> x.stream())
				.collect(Collectors.joining(","));
		System.out.println(collect);
	}
	
}
