package com.example.springbootstudyjpa.controller;

import com.example.springbootstudyjpa.dao.RoleRepository;
import com.example.springbootstudyjpa.dao.UserRepository;
import com.example.springbootstudyjpa.pojo.Role;
import com.example.springbootstudyjpa.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class Usercontroller {

	@Resource
	private UserRepository userRepository;
	@Resource
	private RoleRepository roleRepository;
	
	@RequestMapping("/findAllUser")
	List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@RequestMapping("/finAllRole")
	List<Role> getRoles(){
		return roleRepository.findAll();
	}

}
