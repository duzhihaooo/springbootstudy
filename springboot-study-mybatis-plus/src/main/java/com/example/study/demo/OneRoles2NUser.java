package com.example.study.demo;

import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@TableName("nusers_1role")
public class OneRoles2NUser {
    //@TableId
    private Long id;
    //实体类中的字段是否应与数据库中表的字段相匹配
    @TableField("user_id")
    private Long uid;
    @TableField("role_id")
    private Long rid;
    
    @TableField(exist = false)
    private String roleName;
    @TableField(exist = false)
    List<User> users;
}