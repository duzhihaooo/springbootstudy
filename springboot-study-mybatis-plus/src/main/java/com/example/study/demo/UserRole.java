package com.example.study.demo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("nuser_1role")
public class UserRole {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("user_id")
    private Long uid;
    @TableField("role_id")
    private Long rid;
    /*
     uid  rid
     1    1
     2    1
     3    1
     1    2
     1    3
     1    4
     */
}