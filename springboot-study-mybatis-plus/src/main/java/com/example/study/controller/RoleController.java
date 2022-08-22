package com.example.study.controller;

import com.example.study.demo.OneRoles2NUser;
import com.example.study.demo.Role;
import com.example.study.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Resource
	private RoleService roleService;
	
	/**
	 * 查询所有角色
	 */
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public List<Role> getAllRole(){
		return roleService.listRole();
	}
	
	/**
	 * 查询一个角色对应多个用户
	 * @return
	 */
	@RequestMapping(value = "/one-role-n-users",method = RequestMethod.GET)
	public List<OneRoles2NUser> oneRoles2NUsers(){
		return roleService.getRolesUser();
	}
	
	/**
	 * 添加一个角色
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public Role add(@RequestBody Role role){
		roleService.add(role);
		return role;
	}
	
	/**
	 * 根据id 删除用户
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public String delete(@PathVariable int id){
		int re = roleService.delete(id);
		if (re >= 1){
			return "删除成功";
		}else {
			return "删除失败";
		}
	}
	
	@RequestMapping(value = "/",method = RequestMethod.PUT)
	public int update(@RequestBody Role role){
		return roleService.update(role);
	}

}
