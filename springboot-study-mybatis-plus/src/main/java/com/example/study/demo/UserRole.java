package com.example.study.demo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user_role")
public class UserRole {
    private Long id;
    private Long uid;
    private Long rid;
    /***
     * uid  role
     * 1    1
     * 2    1
     * 3    1
     * 1    2
     * 1    3
     * 1    4
     */
}