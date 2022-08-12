package com.example.springbootstudymybatis.controller;

import com.example.springbootstudymybatis.pojo.User;
import com.example.springbootstudymybatis.pojo.UserRole;
import com.example.springbootstudymybatis.pojo.User_2NRoles;
import com.example.springbootstudymybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController

public class UserController {

	@Autowired
	private UserService userService;
	
	//查找用户
	@RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
	public User getUserInfo(){
		
		return userService.getUserInfo(5);
	}
	
	//删除用户
	@RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
	public String deleteUser(){
		int result = userService.deleteUser(18);
		if (result >= 1){
			return "删除成功";
		} else {
			return "删除失败";
		}
	}
	//新增用户
	@RequestMapping(value = "/addUser",method = RequestMethod.GET)
	public String addUser(){
		User user = new User();
		//user.setId(18);
		//好像不用像mybatis-plus需要再实体类中设置Id主键自增，可以实现添加自动自增
		user.setUser_name("Kid Mili");
		//数据库能够添加成功，但是网页显示报错
		//Console：Mapper method 'com.example.springbootstudymybatis.dao.UserDao.addUser' has an unsupported return type: class com.example.springbootstudymybatis.pojo.User] with root cause
		int result = userService.addUser(user);
		if (result >= 1){
			return "添加成功:" + user;
		} else {
			return "添加失败";
		}
	}
	
	//修改用户
	@RequestMapping(value = "/updateUser",method = RequestMethod.GET)
	public String updateUser(){
		User user = new User();
		user.setId(9);
		user.setUser_name("HelloKitty");
		int result = userService.updateUser(user);
		if(result >= 1 ){
			return "修改成功:"+user;
		} else {
			return "修改失败";
		}
	}
	
	//查询所有用户信息
	@RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
	public List<User> getAllUser(){
		List<User> list = userService.getAllUser();
		return list;
	}
	
	//查找一个用户对应多个角色
	@RequestMapping(value = "/getOneUser2NRoles",method = RequestMethod.GET)
	public List<User_2NRoles> getOneUser2NRoles(){
		return userService.getOneUser2NRoles();
	}
	
	
	@RequestMapping(value = {"/hello"})
	public String index() {
		return "hello springbootjpa";
	}
	

}
