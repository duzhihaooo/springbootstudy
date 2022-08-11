package com.example.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.demo.UserRole;
import com.example.study.mapper.UserRoleMapper;
import com.example.study.service.User2NRolesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//todo 因为都是属于一个mapper的，索引可以放在一个service中:UserRoleServiceImpl 来进行对应的编写
@Service
public class User2NRolesServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements User2NRolesService {
	
	@Resource
	private UserRoleMapper userRoleMapper;
	
	@Override
	public List<Long> getRoleIdListByUserId(Long userId){
		//新建一个条件约束器
		QueryWrapper queryWrapper = new QueryWrapper<>();
		//将传进来的userId与数据库中的字段user_id相匹配
		queryWrapper.eq("user_id",userId);
		//此时拿到条件约束器，可以进行查询
		//因为通过条件约束器所查询返回的信息是多条数据的一个集合，所以新建一个UserRole的集合去接收
		List<UserRole> userRoleList = userRoleMapper.selectList(queryWrapper);
		//在userrole表中拿到与userId所对应的roleId的一个集合，此时应该遍历该集合，从中提取roleid；
		//新建一个集合去接收rid
		List<Long> roleList = new ArrayList<>();
		for (UserRole userRole:userRoleList){
			//为什么不能用这个方法来写：todo因为遍历只有一个对象，一个是集合，这块应该算是java基础不扎实的问题
			//List<Long> roleList = userRole.getRid();
			
			
			roleList.add(userRole.getRid());
		}
		
		return roleList;
	}
	
}