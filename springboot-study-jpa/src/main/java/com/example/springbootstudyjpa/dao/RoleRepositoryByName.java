package com.example.springbootstudyjpa.dao;

import com.example.springbootstudyjpa.pojo.Role;
import com.example.springbootstudyjpa.pojo.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RoleRepositoryByName extends Repository<Role,Integer> {
	//Repository接口方法名称命名查询
	List<Role> findByRoleName(String name);
	List<Role> findByRoleNameLike(String name);
}
