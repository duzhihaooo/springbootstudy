package com.example.study.service;

import java.util.List;

public interface UserRoleService {
    List<Long> getUserIdListByRoleId(Long roleId);
}