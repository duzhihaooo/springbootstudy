package com.example.study.demo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 一个用户对应多个角色
 * @author shizeying
 * @date 2022/08/08
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OneUser2NRoles {
    private Long id;
    private String userName;
    List<Role> roles;
}