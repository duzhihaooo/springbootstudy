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
    //一个用户对应多个角色
    /*
    * 1.建立一个OneUser2NRoles对象去接收单个user
    * 2.设置字段id，userName对应每个User.id .name
    * 3.对应的多个角色以list集合方式传进来
    * */
    private Integer id;
    private String userName;
    List<Role> roles;
}