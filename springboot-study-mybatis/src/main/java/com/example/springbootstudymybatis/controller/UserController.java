package com.example.springbootstudymybatis.controller;

import com.example.springbootstudymybatis.pojo.UserRole;
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
	
	@RequestMapping(value = "/userrolelist",method = RequestMethod.GET)
	public Map<String, Object> allUser(){
		Map<String,Object> modelMap = new HashMap<>();
		List<UserRole> userRoleList = userService.getUserRole();
		modelMap.put("userrolelist",userRoleList);
		return modelMap;
		
	}
	
	@RequestMapping(value = {"/hello"})
	public String index() {
		return "hello springbootjpa";
	}
	

}
