package com.example.springbootstudyjpa.dao;

import com.example.springbootstudyjpa.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
	@Query(value = "select role_id from nuser_1role where user_id = ?",nativeQuery = true)
	List<Integer> findRidByUid(int uid);
	@Query(value = "select user_id from nuser_1role where role_id = ?",nativeQuery = true)
	List<Integer> findUidByRid(int uid);
}
