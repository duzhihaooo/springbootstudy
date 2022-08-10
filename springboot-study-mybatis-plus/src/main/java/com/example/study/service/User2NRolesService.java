package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.demo.UserRole;

import java.util.List;

public interface User2NRolesService extends IService<UserRole> {
	
	List<Long> getRoleIdListByUserId(Long userId);
}
