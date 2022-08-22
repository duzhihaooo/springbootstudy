package com.example.springbootstudyjpa.service.impl;

import com.example.springbootstudyjpa.dao.RoleRepository;
import com.example.springbootstudyjpa.dao.UserRepository;
import com.example.springbootstudyjpa.dao.UserRoleRepository;
import com.example.springbootstudyjpa.pojo.Role;
import com.example.springbootstudyjpa.pojo.User;
import com.example.springbootstudyjpa.pojo.User2NRoles;
import com.example.springbootstudyjpa.pojo.UserRole;
import com.example.springbootstudyjpa.service.UserRoleService;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    UserRoleRepository userRoleRepository;
    @Resource
    UserRepository userRepository;
    @Resource
    RoleRepository roleRepository;
    
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
    
    @Override
    public User2NRoles addUserAddRole(User2NRoles user2NRoles){
        User user = new User();
        List<Role> roleList = new ArrayList<>();
        user.setUserName(user2NRoles.getUserName());
        roleList = user2NRoles.getRoleList();
    
        User saveUser = userRepository.save(user);
        int uid = saveUser.getId();

        for (Role role:roleList){
            Role saveRole = roleRepository.save(role);
            int rid = saveRole.getId();
            UserRole userRole = new UserRole();
            userRole.setUid(uid);
            userRole.setRid(rid);
            userRoleRepository.save(userRole);
        }
        return user2NRoles;
    }
}
