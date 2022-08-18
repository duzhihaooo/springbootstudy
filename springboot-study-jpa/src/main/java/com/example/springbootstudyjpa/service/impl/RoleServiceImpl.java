package com.example.springbootstudyjpa.service.impl;

import com.example.springbootstudyjpa.dao.RoleRepository;
import com.example.springbootstudyjpa.dao.UserRepository;
import com.example.springbootstudyjpa.dao.UserRoleRepository;
import com.example.springbootstudyjpa.pojo.Role;
import com.example.springbootstudyjpa.pojo.Role2NUsers;
import com.example.springbootstudyjpa.pojo.User;
import com.example.springbootstudyjpa.service.RoleService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleRepository     roleRepository;
    @Resource
    UserRoleRepository userRoleRepository;
    @Resource
    UserRepository     userRepository;
    
    //todo:为什么不能用实体类Role去接收 com.example.springbootstudyjpa.pojo.Role这个不就是实体类的路径吗
    // TODO: 2022/8/15 :JpaRepository仓库中的findById方法返回的是Optional<T> Optional这个不太懂
    @Override
    public Role getRoleInfo(int id) {
        /**
         * 思路
         */
        
        return roleRepository.findById(id).orElse(null);
    }
    
    @Override
    public void deleteRole(final int id) {
        roleRepository.deleteById(id);
    }
    
    @Override
    public Role addRole(final Role role) {
        return roleRepository.save(role);
    }
    
    @Override
    public void updateRole(final Role role) {
        roleRepository.save(role);
    }
    
    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
    
    @Override
    public List<Role> findByRoleName(String name) {
        return roleRepository.findByRoleName(name);
    }
    
    @Override
    public List<Role> findByRoleNameLike(String name) {
        return roleRepository.findByRoleNameLike(name);
    }
    
    @Override
    public List<Role2NUsers> findRole2NUsers() {
        List<Role2NUsers> list_RU = new ArrayList<>();
        //遍历所有Role对象，将其填写到Role2NUsers对象中
        for (Role role : getAllRole()) {
            Role2NUsers role2NUsers = new Role2NUsers();
            role2NUsers.setId(role.getId());
            role2NUsers.setRoleName(role.getRoleName());
            //通过拿到的rid，可以在userrole表中拿到对应的userId集合
            List<Integer> userIdList = userRoleRepository.findUidByRid(role2NUsers.getId());
            List<User> userList = new ArrayList<>();
            //再将所拿到的对应的userIdList遍历，在user表中，通过uid得到对应的user信息
            for (Integer id : userIdList) {
                User user = new User();
                user = userRepository.findById(id).orElse(null);
                userList.add(user);
            }
            role2NUsers.setUserList(userList);
            list_RU.add(role2NUsers);
        }
        return list_RU;
    }
    
}