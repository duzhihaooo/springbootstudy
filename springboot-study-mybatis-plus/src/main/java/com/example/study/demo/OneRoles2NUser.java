package com.example.study.demo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * N个用户对应一个角色
 * @author shizeying
 * @date 2022/08/08
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OneRoles2NUser {
    private Long id;
    private String roleName;
    List<User> users;
}