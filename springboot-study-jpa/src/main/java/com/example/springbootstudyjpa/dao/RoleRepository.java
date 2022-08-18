package com.example.springbootstudyjpa.dao;

import com.example.springbootstudyjpa.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//todo 使用@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	//Repository接口方法名称命名查询
	List<Role> findByRoleName(String name);
	List<Role> findByRoleNameLike(String name);
	
}