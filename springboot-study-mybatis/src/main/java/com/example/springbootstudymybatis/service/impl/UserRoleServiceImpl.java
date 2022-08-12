package com.example.springbootstudymybatis.service.impl;

import com.example.springbootstudymybatis.dao.UserRoleDao;
import com.example.springbootstudymybatis.pojo.User;
import com.example.springbootstudymybatis.pojo.UserRole;
import com.example.springbootstudymybatis.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	UserRoleDao userRoleDao;
	
	//查询指定用户角色对应关系
	@Override
	public UserRole getUserRoleInfo(int id){
		return userRoleDao.getUserRoleInfo(id);
	}
	//删除用户角色对应关系
	@Override
	public int deleteUserRole(int id){
		return userRoleDao.deleteUserRole(id);
	}
	//新增用户角色对应关系
	@Override
	public int addUserRole(UserRole userRole){
		return userRoleDao.addUserRole(userRole);
	}
	//修改用户角色对应关系
	@Override
	public int updateUserRole(UserRole userRole){
		return userRoleDao.updateUserRole(userRole);
	}
	//查询所有用户角色对应关系信息
	@Override
	public List<UserRole> getAllUserRole(){
		return userRoleDao.getAllUserRole();
	}
	
	//UserServiceImpl层中：通过uid拿到rid
	@Override
	public List<Integer> getRoleIdListByUserId(int id){
		List<UserRole> list1 = userRoleDao.getRoleIdListByUserId(id);
		List<Integer> list2 = new ArrayList<>();
		for (UserRole userRole:list1){
			list2.add(userRole.getRole_id());
		}
		return list2;
	}
	
	//RoleServiceImpl层中：通过rid拿到uid
	@Override
	public List<Integer> getUserIdListByRoleId(int id){
		List<UserRole> list1 = userRoleDao.getUserIdListByRoleId(id);
		List<Integer> list2 = new ArrayList<>();
		for (UserRole userRole:list1){
			list2.add(userRole.getRole_id());
		}
		return list2;
	}
}
