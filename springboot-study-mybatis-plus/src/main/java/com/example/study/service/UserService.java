package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.demo.OneUser2NRoles;
import com.example.study.demo.User;

import java.util.List;

public interface UserService extends IService<User> {
	List<User> listUser();
    
	List<User> getUsersByIds(List<Long> userIds);
	
	
	List<OneUser2NRoles> getOneUser2NRoles();
	
}