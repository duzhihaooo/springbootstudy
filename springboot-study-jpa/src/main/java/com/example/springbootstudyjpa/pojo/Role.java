package com.example.springbootstudyjpa.pojo;


import lombok.Data;

import javax.persistence.*;

import org.hibernate.annotations.Table;

@Data
@Entity
public class Role {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //生成主键自增
	private Integer id;
	@Column(name = "role_name")
	private String roleName;

}