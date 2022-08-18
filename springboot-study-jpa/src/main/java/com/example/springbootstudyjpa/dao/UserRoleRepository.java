package com.example.springbootstudyjpa.dao;

import com.example.springbootstudyjpa.pojo.UserRole;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<Integer> findRidByUid(int uid);
    
    List<Integer> findUidByRid(int uid);
    
    List<UserRole> findUserRoleByUid(int uid);
    
}