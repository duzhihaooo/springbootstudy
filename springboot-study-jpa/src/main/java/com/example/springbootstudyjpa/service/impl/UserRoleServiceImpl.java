package com.example.springbootstudyjpa.service.impl;

import com.example.springbootstudyjpa.dao.UserRoleRepository;
import com.example.springbootstudyjpa.pojo.UserRole;
import com.example.springbootstudyjpa.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Resource
	UserRoleRepository userRoleRepository;
	
	@Override
	public UserRole getUserRoleInfo(final int id) {
		return userRoleRepository.findById(id).orElse(null);
	}
	
	@Override
	public void deleteUserRole(final int id) {
		userRoleRepository.deleteById(id);
	}
	
	@Override
	public UserRole addUserRole(final UserRole userRole) {
		return userRoleRepository.save(userRole);
	}
	
	@Override
	public void updateUserRole(final UserRole userRole) {
		userRoleRepository.save(userRole);
	}
	
	@Override
	public List<UserRole> getAllUserRole() {
		return userRoleRepository.findAll();
	}
	
}
