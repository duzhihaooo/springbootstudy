package com.example.study.controller;

import com.example.study.demo.UserRole;
import com.example.study.service.UserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserRoleController {
	
	@Resource
	UserRoleService userRoleService;
	
	//查找
	@RequestMapping(value = "getUserRole",method = RequestMethod.GET)
	public List<UserRole> listUserRole(){
		return userRoleService.listUserRole();
	}
	
	//添加
	@RequestMapping(value = "addUserRole",method = RequestMethod.GET)
	public UserRole add(){
		//新建一个对象
		UserRole userRole = new UserRole();
		//将所想添加的信息传入UserRole对象里
		userRole.setUid(5L);
		userRole.setRid(9L);
		//再将userRole 传入 userRoleService方法里
		userRoleService.add(userRole);
		
		return userRole;
	}
	
	//删除
	@RequestMapping(value = "deleteUserRole",method = RequestMethod.GET)
	public Object delete(){
		//新建一个对象
		UserRole userRole = new UserRole();
		//再将想删除的信息传入userRole对象里
		userRole.setId(13L);
		//再将用UserROleService层的delete方法
		userRoleService.delete(userRole);
		
		return userRoleService.listUserRole();
	}
	
	//修改
	@RequestMapping(value = "updateUserRole",method = RequestMethod.GET)
	public UserRole update(){
		//新建一个对象
		UserRole userRole = new UserRole();
		//再将想修改的信息传入userRole对象里
		userRole.setId(10L);
		userRole.setUid(6L);
		userRole.setRid(6L);
		//再将用UserROleService层的delete方法
		userRoleService.update(userRole);
		
		return userRole;
		
	}
	
	
}
