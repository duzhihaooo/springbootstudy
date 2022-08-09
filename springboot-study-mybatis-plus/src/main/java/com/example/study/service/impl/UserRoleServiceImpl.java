package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.demo.OneRoles2NUser;
import com.example.study.mapper.OneRoles2NUserMapper;
import com.example.study.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleServiceImpl extends ServiceImpl<OneRoles2NUserMapper, com.example.study.demo.OneRoles2NUser> implements UserRoleService {

	@Resource
	private OneRoles2NUserMapper oneRoles2NUserMapper;
	
	@Override
	public List<OneRoles2NUser> getUserIdListByRoleId(Long roleId){
		/*1.为什么是用List去接收，因为传进来的只有1个roleId
		  2.是不是应该用条件约束器，使进传来的roleId与数据库中的role_id匹配，从而拿到user_id
		  3.基础太差，不知道该如何通过传进来的roleId与实体类的rid相匹配再拿到实体类的uid（应该是从oneRoles2NUserMapper.方法里面获取）
		  
		  */
		List<OneRoles2NUser> list = oneRoles2NUserMapper.selectById(roleId);
		
	
	
	}

}
