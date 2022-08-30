package com.example.springbootstudymybatis.test;

import com.example.springbootstudymybatis.dao.UserDao;
import com.example.springbootstudymybatis.dao.UserRoleDao;
import com.example.springbootstudymybatis.pojo.Role;
import com.example.springbootstudymybatis.pojo.User;
import com.example.springbootstudymybatis.pojo.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class Test01 {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Test
	public void test01(){
		//List<User> list = userDao.getAllUserTest();
		//System.out.println(list);
	}
	
	@Test
	public void test02(){
		List<UserRole> list = userRoleDao.getUserIdListByRoleId(3);
		list.forEach(System.out::println);
	}
	
	@Test
	public void test03(){
		User user = new User();
		user.setUserName("PSY3");
		userDao.saveUserGetId(user);
		System.out.println(user.getId());
	}
	
}