package com.example.springbootstudyjpa.pojo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2NRoles {
    private Integer id;
    private String  userName;
    List<Role> roleList;
}