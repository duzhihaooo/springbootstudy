package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.demo.OneRoles2NUser;
import com.example.study.demo.UserRole;

import java.util.List;

public interface UserRoleService extends IService<UserRole> {
    
    //不清楚是该用List<Long> 还是 List<OneRoles2NUser>去获取uid
    
    
    //List<Long> getUserIdListByRoleId(Long roleId);
    
    List<Long> getUserIdListByRoleId(Long roleId);
    /*
    List<Long> getRoleIdListByUserId(Long userId);
    */
}