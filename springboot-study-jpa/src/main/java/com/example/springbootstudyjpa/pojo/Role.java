package com.example.springbootstudyjpa.pojo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Table;

@Data
@Entity
public class Role {
	
	@Id
	private Integer id;
	private String roleName;
	private Integer userId;

}