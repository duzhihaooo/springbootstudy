package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.demo.OneUser2NRoles;
import com.example.study.demo.Role;
import com.example.study.demo.User;
import com.example.study.mapper.RoleMapper;
import com.example.study.mapper.UserMapper;
import com.example.study.service.RoleService;
import com.example.study.service.User2NRolesService;
import com.example.study.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private User2NRolesService user2NRolesService;
	
	/*
	@Resource
	private RoleService roleService;
	//依赖循环的话该怎么解决
	*/
	
	
	@Override
	public List<User> getUsersByIds(List<Long> userIds) {
		List<User> userList=new ArrayList<>();
		for (Long id : userIds) {
			User user = userMapper.selectById(id);
			userList.add(user);
			
		}
		return userList;
	}
	/**
	 * @Transactional :update insert delete
	 */
	
	
	@Override
	//先查询User集合
	public List<User> listUser() {
		return userMapper.selectList(null);
	}
	
	@Override
	public List<OneUser2NRoles> getOneUser2NRoles(){
		//新建一个OneUser2NRoless集合
		List<OneUser2NRoles> listOneUser2NRoles = new ArrayList<>();
		//遍历User集合              ？？：这里的listUser是该层的listUser方法吗？ 在ServiceImpl可以直接调用方法获取的结果吗？
		for (User user:listUser()){
			OneUser2NRoles oneUser2NRoles = new OneUser2NRoles();
			//将遍历的User.id 字段 赋为 oneUser2NRoles.id
			oneUser2NRoles.setId(user.getId());
			//将遍历的User.name 字段 赋为 oneUser2NRoles.userName
			oneUser2NRoles.setUserName(user.getUserName());
			//将得到的遍历的user.id通过UserRoleService层中getRoleIdListByUserId方法拿到roleId
			//此时应该去userRoleService去实现getRoleIdListByUserId方法
			List<Long> roleIdList = user2NRolesService.getRoleIdListByUserId(user.getId());
			
			//通过数据库中表UserRole，拿到了与userId对应的roleId，此时应该到数据库表Role中拿到与roleId所对应的相关详细信息
			//List<Role> roleList = roleService.getRolesById(roleIdList);
			List<Role> roleList2 = new ArrayList<>();
			for (Long id:roleIdList){
				Role role = roleMapper.selectById(id);
				roleList2.add(role);
				
			}
			
			
			
			//将所查询出的详细角色信息再添加回oneUser2Nroles的List<Role>集合中
			oneUser2NRoles.setRoles(roleList2);
			
			//再将设置好的oneUser2NRoles对象再添加回集合listOneUser2NRoles中
			listOneUser2NRoles.add(oneUser2NRoles);
		}
		
		return listOneUser2NRoles;
		
		
	}
	
	

}