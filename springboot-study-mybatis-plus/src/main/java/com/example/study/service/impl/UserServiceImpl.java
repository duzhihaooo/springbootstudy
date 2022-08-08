package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.demo.User;
import com.example.study.mapper.UserMapper;
import com.example.study.service.UserService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
	@Resource
	private UserMapper userMapper;
	
	@Override
	public List<User> listUser() {
		return userMapper.selectList(null);
	}
	/**
	 * @Transactional :update insert delete
	 */
	

}