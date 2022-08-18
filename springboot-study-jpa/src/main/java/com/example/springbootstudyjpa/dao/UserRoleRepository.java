package com.example.springbootstudyjpa.dao;

import com.example.springbootstudyjpa.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
	List<Integer> findRidByUid(int uid);
	List<Integer> findUidByRid(int uid);
	
	List<UserRole> findUserRoleByUid(int uid);
	
}