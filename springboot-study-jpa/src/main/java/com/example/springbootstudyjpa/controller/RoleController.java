package com.example.springbootstudyjpa.controller;

import com.example.springbootstudyjpa.pojo.Role;
import com.example.springbootstudyjpa.pojo.Role2NUsers;
import com.example.springbootstudyjpa.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleController {
	@Resource
	RoleService roleService;
	//根据指定id查找角色
	@RequestMapping(value = "/getRoleInfo",method = RequestMethod.GET)
	public Role getRoleInfo(){
		return roleService.getRoleInfo(5);
	}
	//根据指定id删除角色
	@RequestMapping(value = "/deleteRole",method = RequestMethod.GET)
	public void deleteRole(){
		roleService.deleteRole(13);
	}
	//新增角色
	@RequestMapping(value = "/addRole",method = RequestMethod.GET)
	public Role addRole(){
		Role role = new Role();
		role.setRoleName("POLICEMAN");
		return roleService.addRole(role);
	}
	//修改角色
	@RequestMapping(value = "/updateRole",method = RequestMethod.GET)
	public void updateRole(){
		Role role = new Role();
		role.setId(9);
		role.setRoleName("Trainer");
		roleService.updateRole(role);
	}
	//查询所有用户信息
	@RequestMapping(value = "/getAllRole",method = RequestMethod.GET)
	public List<Role> getAllRole(){
		return roleService.getAllRole();
	}
	//Repository接口方法名称命名查询
	@RequestMapping(value = "/findByRoleName",method = RequestMethod.GET)
	public List<Role> findByRoleName(){
		return roleService.findByRoleName("Pilot");
	}
	@RequestMapping(value = "/findByRoleNameLike",method = RequestMethod.GET)
	public List<Role> findByRoleNameLike(){
		return roleService.findByRoleNameLike("P%");
	}
	//基于@Query注解查询
	@RequestMapping(value = "/queryByRoleName",method = RequestMethod.GET)
	public List<Role> queryByRoleName(){
		return roleService.queryByRoleName("Pilot");
	}
	
	//查询一个角色对应多个用户
	@RequestMapping(value = "/findRole2NUsers",method = RequestMethod.GET)
	public List<Role2NUsers> findRole2NUsers(){
		return roleService.findRole2NUsers();
	}
	
}
