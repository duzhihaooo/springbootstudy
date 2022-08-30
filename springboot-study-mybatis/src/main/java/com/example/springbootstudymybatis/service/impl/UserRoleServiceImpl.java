package com.example.springbootstudymybatis.service.impl;

import com.example.springbootstudymybatis.dao.RoleDao;
import com.example.springbootstudymybatis.dao.UserDao;
import com.example.springbootstudymybatis.dao.UserRoleDao;
import com.example.springbootstudymybatis.pojo.Role;
import com.example.springbootstudymybatis.pojo.User;
import com.example.springbootstudymybatis.pojo.User2NRoles;
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
	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;
	@Override
	public User2NRoles addUserAddRole(User2NRoles user2NRoles){
		User user = new User();
		user.setUserName(user2NRoles.getUserName());
		userDao.saveUserGetId(user);
		int uid = 0;
		int rid = 0;
		for (Role role1:user2NRoles.getRoleList()){
			Role role2 = new Role();
			role2.setRoleName(role1.getRoleName());
			roleDao.saveRoleGetId(role2);

			uid = user.getId();
			rid = role2.getId();
			UserRole userRole = new UserRole();
			userRole.setUserId(uid);
			userRole.setRoleId(rid);
			userRoleDao.addUserRole(userRole);
		}
		return user2NRoles;
	}
	
	
	
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
			list2.add(userRole.getRoleId());
		}
		return list2;
	}
	
	//RoleServiceImpl层中：通过rid拿到uid
	@Override
	public List<Integer> getUserIdListByRoleId(int id){
		List<UserRole> list1 = userRoleDao.getUserIdListByRoleId(id);
		List<Integer> list2 = new ArrayList<>();
		for (UserRole userRole:list1){
			list2.add(userRole.getRoleId());
		}
		return list2;
	}
}
