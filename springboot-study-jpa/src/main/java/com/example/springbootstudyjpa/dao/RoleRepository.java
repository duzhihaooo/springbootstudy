package com.example.springbootstudyjpa.dao;

import com.example.springbootstudyjpa.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
