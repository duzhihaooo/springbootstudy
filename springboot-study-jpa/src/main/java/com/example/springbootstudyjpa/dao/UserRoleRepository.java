package com.example.springbootstudyjpa.dao;

import com.example.springbootstudyjpa.pojo.UserRole;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    @Query(value = "select role_id from nuser_1role where user_id = ?1",nativeQuery = true)
    List<Integer> findRidByUid(int uid);
    
    @Query(value = "select user_id from nuser_1role where role_id = ?1",nativeQuery = true)
    List<Integer> findUidByRid(int rid);
    
    List<UserRole> findUserRoleByUid(int uid);
    
}