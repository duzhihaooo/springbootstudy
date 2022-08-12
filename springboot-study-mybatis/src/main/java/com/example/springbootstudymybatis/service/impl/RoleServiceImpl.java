package com.example.springbootstudymybatis.service.impl;

import com.example.springbootstudymybatis.dao.RoleDao;
import com.example.springbootstudymybatis.dao.UserDao;
import com.example.springbootstudymybatis.dao.UserRoleDao;
import com.example.springbootstudymybatis.pojo.Role;
import com.example.springbootstudymybatis.pojo.Role_2NUser;
import com.example.springbootstudymybatis.pojo.User;
import com.example.springbootstudymybatis.service.RoleService;
import com.example.springbootstudymybatis.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleDao roleDao;
	@Autowired
	UserDao userDao;
	@Autowired
	//在Service层中可以调用另外Service实现层中的方法！！！
	UserRoleService userRoleService;
	
	//查询指定用户
	@Override
	public Role getRoleInfo(int id){
		return roleDao.getRoleInfo(id);
	}
	
	//删除用户
	public int deleteRole(int id){
		return roleDao.deleteRole(id);
	}
	
	//新增角色
	public int addRole(Role role){
		return roleDao.addRole(role);
	}
	
	//修改角色
	public int updateRole(Role role){
		return roleDao.updateRole(role);
	}
	
	//查询所有角色信息
	public List<Role> getAllRole(){
		return roleDao.getAllRole();
	}
	
	//查找一个角色对应多个用户
	public List<Role_2NUser> getOneRole2NUsers(){
		//先拿到所有角色信息
		List<Role> roleList = roleDao.getAllRole();
		//新建一个List<Role_2NUser>数组，方便之后填入Role_2NUser对象的信息
		List<Role_2NUser> list_RU = new ArrayList<>();
		//遍历roleList将所有角色信息填入Role_2NUser对象中
		for (Role role:roleList){
			Role_2NUser role_2NUser = new Role_2NUser();
			role_2NUser.setId(role.getId());
			role_2NUser.setRoleName(role.getRole_name());
			//再将填写好的role_2NUser对象传入数组list_RU
			list_RU.add(role_2NUser);
			//将拿到的rid可以在表UserRole中找出对应的uid
			//此时拿到的是对应rid的uid集合
			List<Integer> userIdList = userRoleService.getUserIdListByRoleId(role_2NUser.getId());
			
			List<User> userList = new ArrayList<>();
			//拿到uid之后，可以在表User中拿到对应的User信息
			for (Integer id:userIdList){
				User user =userDao.getUserInfo(id);
				userList.add(user);
			}
			//将拿到的对应的userList信息填入role_2NUser对象中
			role_2NUser.setUserList(userList);
			//再将填写好的role_2NUser对象加进list_RU集合中
			list_RU.add(role_2NUser);
		}
		return list_RU;
	}
	
	
}
