package com.example.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.demo.Role;
import com.example.study.demo.User;
import com.example.study.demo.UserRole;
import com.example.study.mapper.UserRoleMapper;
import com.example.study.service.UserRoleService;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper,UserRole> implements UserRoleService {
	
	@Resource
	private UserRoleMapper userRoleMapper;
	
	@Override
	public List<Long> getUserIdListByRoleId(Long roleId) {
		/*1.为什么是用List去接收，因为传进来的只有1个roleId
		  2.是不是应该用条件约束器，使进传来的roleId与数据库中的role_id匹配，从而拿到user_id
		  3.基础太差，不知道该如何通过传进来的roleId与实体类的rid相匹配再拿到实体类的uid（应该是从oneRoles2NUserMapper.方法里面获取）
		  */
		//构建新的条件约束器
		QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
		//判断role_id与roleId字段匹配
		wrapper.eq("role_id", roleId);
		//通过传进来的roleId拿到相对应的userrole集合
		List<UserRole> list = userRoleMapper.selectList(wrapper);
		//新建一个userRole数组
		List<Long> userIds = new ArrayList<>();
		//1.遍历刚才拿到对应的userrole集合
		//2.遍历的每一条都是userRole对象
		for (UserRole userRole : list) {
			//通过userRole.getUid方法拿到与roleId相匹配的userId
			userIds.add(userRole.getUid());
		}
		return userIds;
	}

	@Override
	public List<Long> getRoleIdListByUserId(Long userId){
		//新建一个条件约束器
		QueryWrapper queryWrapper = new QueryWrapper<>();
		//将传进来的userId与数据库中的字段user_id相匹配
		queryWrapper.eq("user_id",userId);
		//此时拿到条件约束器，可以进行查询
		//因为通过条件约束器所查询返回的信息是多条数据的一个集合，所以新建一个UserRole的集合去接收
		List<UserRole> userRoleList = userRoleMapper.selectList(queryWrapper);
		//在userrole表中拿到与userId所对应的roleId的一个集合，此时应该遍历该集合，从中提取roleid；
		//新建一个集合去接收rid
		List<Long> roleList = new ArrayList<>();
		for (UserRole userRole:userRoleList){
			//为什么不能用这个方法来写
			//List<Long> roleList = userRole.getRid();
			
			
			roleList.add(userRole.getRid());
		}
		
		return roleList;
	}
	
	//查找
	@Override
	public  List<UserRole> listUserRole(){
		return userRoleMapper.selectList(null);
	}
	
	//添加
	@Override
	public int add(UserRole userRole){
		int row = userRoleMapper.insert(userRole);
		return row;
	}
	
	//删除
	@Override
	public int delete(int id){
		return userRoleMapper.deleteById(id);
	}
	
	//修改
	@Override
	public int update(UserRole userRole){
		int row = userRoleMapper.updateById(userRole);
		return row;
	}
	
	
	
	
}