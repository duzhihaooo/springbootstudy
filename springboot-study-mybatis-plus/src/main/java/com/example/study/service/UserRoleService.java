package com.example.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.study.demo.OneRoles2NUser;

import java.util.List;

public interface UserRoleService extends IService {
    
    //不清楚是该用List<Long> 还是 List<OneRoles2NUser>去获取uid
    
    
    //List<Long> getUserIdListByRoleId(Long roleId);
    
    List<OneRoles2NUser> getUserIdListByRoleId(Long roleId);
}