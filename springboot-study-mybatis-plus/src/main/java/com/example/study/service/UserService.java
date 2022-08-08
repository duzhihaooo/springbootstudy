package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.demo.User;

import java.util.List;

public interface UserService extends IService<User> {
	List<User> listUser();
}
