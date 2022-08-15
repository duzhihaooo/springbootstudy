package com.example.springbootstudyjpa.dao;

import com.example.springbootstudyjpa.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	//基于@Query注解查询
	@Query(value = "select * from role where role_name = ?",nativeQuery = true)
	List<Role> queryByRoleName(String name);
	
	@Query(value = "select * from role where id = ?",nativeQuery = true)
	Role getRolebyId(int id);
	
}
