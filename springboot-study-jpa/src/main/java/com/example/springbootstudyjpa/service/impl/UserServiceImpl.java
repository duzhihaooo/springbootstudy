package com.example.springbootstudyjpa.service.impl;

import com.example.springbootstudyjpa.dao.RoleRepository;
import com.example.springbootstudyjpa.dao.UserRepository;
import com.example.springbootstudyjpa.dao.UsersRepositoryByName;
import com.example.springbootstudyjpa.pojo.Role;
import com.example.springbootstudyjpa.pojo.User;
import com.example.springbootstudyjpa.pojo.User2NRoles;
import com.example.springbootstudyjpa.service.UserRoleService;
import com.example.springbootstudyjpa.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
	//导入dao层接口
	@Resource
	UserRepository userRepository;
	@Resource
	UsersRepositoryByName usersRepositoryByName;
	@Resource
	UserRoleService userRoleService;
	@Resource
	RoleRepository roleRepository;
	
	@Override
	public User getUserInfo(Integer id) {
		Optional<User> list = userRepository.findById(id);
		return list.get();
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public User addUser(final User user) {
		return userRepository.save(user);
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateUser(final User user) {
		userRepository.save(user);
	}
	
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	@Override
	public List<User> findByUserName(String str){
		return usersRepositoryByName.findByUserName(str);
	}
	
	@Override
	public List<User> findByUserNameLike(String str){
		return usersRepositoryByName.findByUserNameLike(str);
	}
	
	@Override
	public List<User> queryByNameUseSQL(String str){
		//return userRepository.queryByNameUser(str);
		return null;
	}
	
	/*
	@Override
	public void updateUsersNameById(String name,String id){
		userRepository.updateUsersNameById(name,id);
	}
	*/
	
	@Override
	public List<User2NRoles> findUser2NRoles() {
		List<User2NRoles> list_UR = new ArrayList<>();
		//遍历所有User信息，将其填充到User2NRoles实体类呈现
		for (User user:getAllUser()){
			User2NRoles user2NRoles = new User2NRoles();
			user2NRoles.setId(user.getId());
			user2NRoles.setUserName(user.getUserName());
			//通过uid在userrole关联表中拿到与其对应的rid集合
			List<Integer> roleIdList = userRoleService.findRidByUid(user2NRoles.getId());
			List<Role> roleList = new ArrayList<>();
			//再通过拿到的roleList集合，将其遍历在Role表中得到向对应rid的role信息
			for (int id:roleIdList){
				Role role = new Role();
				//role = roleService.getRoleInfo(id);
				role = roleRepository.getRolebyId(id);
				roleList.add(role);
			}
			//拿到与其对应的多个role信息集合，再将其传回user2Nroles对象中
			user2NRoles.setRoleList(roleList);
			list_UR.add(user2NRoles);
		}
		return list_UR;
	}
	
	@Override
	public User getUserById(final int id) {
		return userRepository.findById(id).orElse(null);
	}
}