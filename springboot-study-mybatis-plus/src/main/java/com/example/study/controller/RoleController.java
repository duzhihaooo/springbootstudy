package com.example.study.controller;

import com.example.study.demo.OneRoles2NUser;
import com.example.study.demo.Role;
import com.example.study.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleController {

	@Resource
	private RoleService roleService;
	
	//查询一个角色对应多个用户
	@RequestMapping(value = "get-role-users",method = RequestMethod.GET)
	public List<OneRoles2NUser> oneRoles2NUsers(){
		
		return roleService.getRolesUser();
	}
	
	//添加一个用户
	@RequestMapping(value = "addRole",method = RequestMethod.GET)
	public Role add(){
		//设置一个新对象
		Role role = new Role();
		//再将所填入的信息通过set方法传入
		role.setRoleName("chef");
		//调用roleService层的add方法将role传进去
		roleService.add(role);
		
		return role;
	}
	
	@RequestMapping(value = "deleteRole",method = RequestMethod.GET)
	//删除一个用户
	public Object delete(){
		//新建一个对象
		Role role = new Role();
		//将所想删除数据的id传进role里面
		role.setId(11L);
		
		roleService.delete(role);
		
		return roleService.listRole();
	}
	
	@RequestMapping(value = "updataRole",method = RequestMethod.GET)
	public Role update(){
		//新建一个对象
		Role role = new Role();
		//将所想修改数据的id roleName 传进role里面
		role.setId(10L);
		role.setRoleName("ProPlayer");
		//再执行Service接口的方法
		roleService.update(role);
		
		return role;
	}

}
