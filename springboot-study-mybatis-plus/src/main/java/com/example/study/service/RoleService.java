package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.demo.Role;
import com.example.study.demo.User;

import java.util.List;

public interface RoleService extends IService<Role> {
	List<Role> listRole();
}
