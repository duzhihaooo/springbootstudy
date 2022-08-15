package com.example.springbootstudyjpa.dao;

import com.example.springbootstudyjpa.pojo.Role;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositoryByName extends JpaRepository<Role,Integer> {
	//Repository接口方法名称命名查询
	List<Role> findByRoleName(String name);
	List<Role> findByRoleNameLike(String name);
}