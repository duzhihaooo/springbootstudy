package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.demo.User;
import com.example.study.mapper.UserMapper;
import com.example.study.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
	@Resource
	private UserMapper UserMapper;
	
	@Override
	public List<User> listUser() {
		return UserMapper.listUser();
	}
	

}
