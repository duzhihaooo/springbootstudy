package com.example.springbootstudyjpa.pojo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role2NUsers {
    private Integer id;
    private String  roleName;
    List<User> userList;
}