package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.demo.Role;
import com.example.study.mapper.RoleMapper;
import com.example.study.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService{
	
	@Resource
	private RoleMapper roleMapper;
	@Override
	public List<Role> listRole(){
		return roleMapper.listRole();
	}
	
}
