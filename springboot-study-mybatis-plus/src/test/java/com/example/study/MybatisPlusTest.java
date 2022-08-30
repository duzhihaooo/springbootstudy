package com.example.study;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.demo.Role;
import com.example.study.demo.User;
import com.example.study.demo.UserRole;
import com.example.study.mapper.RoleMapper;
import com.example.study.mapper.UserMapper;
import com.example.study.mapper.UserRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusTest {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	User user;
	
	@Test
	public void testSelectTest01(){
		List<User> list1 = userMapper.selectList(null);
		List<Role> list2 = roleMapper.selectList(null);
		List<UserRole> list3 = userRoleMapper.selectList(null);
		
		
		
		list1.forEach(System.out::println);
		System.out.println("-----------------------------");
		list2.forEach(System.out::println);
		System.out.println("-----------------------------");
		list3.forEach(System.out::println);
	}
	
	@Test
	public void  testAddUser(){
		User user = new User();
		
		// 数据库中已经设置id为主键，不是传数据进去会自增吗
		// 我不传setId的话 会报错
		user.setId(12);
		user.setUserName("Jay");
		
		int insert = userMapper.insert(user);
		System.out.println("insert:" + insert);
	}
	
	
	
	
}
