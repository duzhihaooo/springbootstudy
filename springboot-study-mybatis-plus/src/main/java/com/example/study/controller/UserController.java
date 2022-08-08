package com.example.study.controller;

import com.example.study.demo.Role;
import com.example.study.demo.User;
import com.example.study.mapper.UserMapper;
import com.example.study.service.RoleService;
import com.example.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/select")
	public List<User> findAll(){
		return userMapper.selectList(null);
	}
	
	@Resource
	private RoleService roleService;
	@Resource
	private UserService userService;
	@RequestMapping("/listUser")
	private List<User> listUser(){
		return userService.listUser();
	}
	@RequestMapping("/listRole")
	private List<Role> listRole(){
		return roleService.listRole();
	}
	
	
	
	@RequestMapping(value = {"/hello"})
	public String index() {
		return "hello springboot";
	}
}
