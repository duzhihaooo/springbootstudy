package com.example.springbootstudymybatis.service.impl;

import com.example.springbootstudymybatis.dao.RoleDao;
import com.example.springbootstudymybatis.dao.UserDao;
import com.example.springbootstudymybatis.pojo.Role;
import com.example.springbootstudymybatis.pojo.User;
import com.example.springbootstudymybatis.pojo.UserRole;
import com.example.springbootstudymybatis.pojo.User_2NRoles;
import com.example.springbootstudymybatis.service.UserRoleService;
import com.example.springbootstudymybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;
	@Autowired
	UserRoleService userRoleService;
	
	//查找用户
	@Override
	public User getUserInfo(int id){
		return userDao.getUserInfo(id);
	}
	
	//删除用户
	@Override
	public int deleteUser(int id){
		return userDao.deleteUser(id);
	}
	
	//新增用户
	@Override
	public int addUser(User user){
		return userDao.addUser(user);
	}
	
	//修改用户
	@Override
	public int updateUser(User user){
		return userDao.updateUser(user);
	}
	
	//查询所有用户信息
	public List<User> getAllUser(){
		return userDao.getAllUser();
	}
	
	//查找一个用户对应多个角色
	@Override
	public List<User_2NRoles> getOneUser2NRoles(){
		//新建一个User_2NRoles数组用来收集user的信息
		List<User_2NRoles> list_UR = new ArrayList<>();
		//遍历所有用户，再遍历过程中将每一个用户信息传入User_2NRoles对象里
		for (User user:getAllUser()){
			User_2NRoles user_2NRoles = new User_2NRoles();
			user_2NRoles.setId(user.getId());
			user_2NRoles.setUserName(user.getUser_name());
			//再将传好的user_2NRoles对象传入数组list_UR
			list_UR.add(user_2NRoles);
			//拿到了用户信息，此时应该在UserRole用户角色关联表中以uid拿到rid
			List<Integer> roleIdList = userRoleService.getRoleIdListByUserId(user_2NRoles.getId());
			
			//拿到对应角色id的集合后，将其遍历再在role表中拿到与其对应的roleName
			List<Role> roleList = new ArrayList<>();
			for (Integer id:roleIdList){
				Role role = roleDao.getRoleInfo(id);
				roleList.add(role);
			}
			
			//再将拿到的对应角色集合再添加到对象user_2NRoles里
			user_2NRoles.setRoleList(roleList);
			//再将填写完整的user_2NRoles对象传入list_UR数组中
			list_UR.add(user_2NRoles);
		}
		return list_UR;
	}
	
}
