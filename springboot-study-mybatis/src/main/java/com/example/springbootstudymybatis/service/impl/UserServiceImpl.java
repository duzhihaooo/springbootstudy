package com.example.springbootstudymybatis.service.impl;

import com.example.springbootstudymybatis.dao.UserDao;
import com.example.springbootstudymybatis.pojo.UserRole;
import com.example.springbootstudymybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Override
	public List<UserRole> getUserRole(){
		List<UserRole> users = userDao.selectUserRoleList();
		return users;
	}
	
}
