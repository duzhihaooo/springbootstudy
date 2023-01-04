package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.demo.OneUser2NRoles;
import com.example.study.demo.Role;
import com.example.study.demo.User;
import com.example.study.demo.UserRole;
import com.example.study.mapper.RoleMapper;
import com.example.study.mapper.UserMapper;
import com.example.study.service.UserRoleService;
import com.example.study.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;

import org.apache.catalina.mbeans.RoleMBean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private UserRoleService userRoleService;
	
	/*
	@Resource
	private RoleService roleService;
	//依赖循环的话该怎么解决
	*/
	
	@Override
	//1.查询User集合
	public List<User> listUser() {
		return userMapper.selectList(null);
		
	}
	
	
	@Override
	//2.查询一个用户对应多个角色
	public List<OneUser2NRoles> getOneUser2NRoles() {
			//新建一个OneUser2NRoless集合
			List<OneUser2NRoles> listOneUser2NRoles = new ArrayList<>();
			//遍历User集合              ？？：这里的listUser是该层的listUser方法吗？ 在ServiceImpl可以直接调用方法获取的结果吗？
			//1.获取全部的用户
			final List<User> users = listUser();
			//2.获取角色
			final List<Role> roles = roleMapper.selectList(null);
			//3.角色和用户userRole所有的信息
			final List<UserRole> userRoles = userRoleService.listUserRole();
			//4.1users->OneUser2NRoles
			final List<OneUser2NRoles> collect = users.stream()
					.map(x -> {
							OneUser2NRoles oneUser2NRoles2 = new OneUser2NRoles();
							oneUser2NRoles2.setId(x.getId());
							oneUser2NRoles2.setUserName(x.getUserName());
							return oneUser2NRoles2;
					})
					.map(oneUser2NRoles2 -> {
							//1->1
							final Integer userId = oneUser2NRoles2.getId();
							final List<Integer> roleIds = userRoles.stream()
									.filter(i -> Objects.equals(i.getUid(), userId))
									.map(i -> i.getRid())
									.collect(Collectors.toList());
							final List<Role> roleList = roles.stream()
									.filter(i -> roleIds.contains(i.getId()))
									.collect(Collectors.toList());
							oneUser2NRoles2.setRoles(roleList);
							return oneUser2NRoles2;
					}).collect(Collectors.toList());
			//4.1users->OneUser2NRoles:使用peek
			final List<OneUser2NRoles> collect2 = users.stream()
					.map(x -> {
							OneUser2NRoles oneUser2NRoles2 = new OneUser2NRoles();
							oneUser2NRoles2.setId(x.getId());
							oneUser2NRoles2.setUserName(x.getUserName());
							return oneUser2NRoles2;
					})
					.peek(oneUser2NRoles2 -> {
							//1。打印一下这个对象
							System.out.println(oneUser2NRoles2);
							//2。设置一下这个对象
							final Integer userId = oneUser2NRoles2.getId();
							final List<Integer> roleIds = userRoles.stream()
									.filter(i -> Objects.equals(i.getUid(), userId))
									.map(i -> i.getRid())
									.collect(Collectors.toList());
							final List<Role> roleList = roles.stream()
									.filter(i -> roleIds.contains(i.getId()))
									.collect(Collectors.toList());
							//设置角色
							oneUser2NRoles2.setRoles(roleList);
					}).collect(Collectors.toList());
			
			//userList->OneUser2NRolesList 实际：users-》roles （user一对->多role）
			//1.user
			final List<Role> collect1 = listUser().stream()
					//1.1 user->oneUser2NRoles2
					.map(x -> {
							OneUser2NRoles oneUser2NRoles2 = new OneUser2NRoles();
							oneUser2NRoles2.setId(x.getId());
							oneUser2NRoles2.setUserName(x.getUserName());
							return oneUser2NRoles2;  //通过以uid拿到的新oneUser2NRoles2.stream()
					})
					//1.2 oneUser2NRoles2-> oneUser2NRoles2 预想 user role关联
					//错误：oneUser2NRoles2-》userId（x.getId())
					// -》roleIdListByUserId=》return roleIdListByUserId=》最终转换为：List《roleId》
					.map(x -> {
							//roleId 集合
							final List<Integer> roleIdListByUserId = userRoleService.getRoleIdListByUserId(
									x.getId());
							return roleIdListByUserId;  //拿到以uid得到的对应ridList
					})
					//
					//roleIds-》roleMapper.selectById(roleId); role
					//1.3 List《roleId》->List《role》
					.map(roleIds -> {
							//通过对应的rid拿到对应的roleName
							return roleIds.stream().map(roleId -> {
									//roleId-map操作>role
									return roleMapper.selectById(roleId);
							}).collect(Collectors.toList());
							
					})
					//list<role>
					.flatMap(i -> i.stream())
					//list<role>
					.collect(Collectors.toList());
			//List<OneUser2NRoles>
			
			for (User user : listUser()) {
					/**
					 * 			OneUser2NRoles oneUser2NRoles = new OneUser2NRoles();
					 * 			//将遍历的User.id 字段 赋为 oneUser2NRoles.id
					 * 			oneUser2NRoles.setId(user.getId());
					 * 			//将遍历的User.name 字段 赋为 oneUser2NRoles.userName
					 * 			oneUser2NRoles.setUserName(user.getUserName());
					 * 		todo .map 算子
					 */
					OneUser2NRoles oneUser2NRoles = new OneUser2NRoles();
					//将遍历的User.id 字段 赋为 oneUser2NRoles.id
					oneUser2NRoles.setId(user.getId());
					//将遍历的User.name 字段 赋为 oneUser2NRoles.userName
					oneUser2NRoles.setUserName(user.getUserName());
					/**
					 * 	//将得到的遍历的user.id通过UserRoleService层中getRoleIdListByUserId方法拿到roleId
					 * 			//此时应该去userRoleService去实现getRoleIdListByUserId方法
					 * 			List<Integer> roleIdList = userRoleService.getRoleIdListByUserId(user.getId());
					 *
					 * 			//通过数据库中表UserRole，拿到了与userId对应的roleId，此时应该到数据库表Role中拿到与roleId所对应的相关详细信息
					 * 			//List<Role> roleList = roleService.getRolesById(roleIdList);
					 * 			List<Role> roleList2 = new ArrayList<>();
					 * 			for (Integer id:roleIdList){
					 * 				Role role = roleMapper.selectById(id);
					 * 				roleList2.add(role);
					 *            }
					 * 			//将所查询出的详细角色信息再添加回oneUser2Nroles的List<Role>集合中
					 * 			oneUser2NRoles.setRoles(roleList2);
					 * 		todo .peek 或者 .map 算子
					 */
					//将得到的遍历的user.id通过UserRoleService层中getRoleIdListByUserId方法拿到roleId
					//此时应该去userRoleService去实现getRoleIdListByUserId方法
					List<Integer> roleIdList = userRoleService.getRoleIdListByUserId(user.getId());
					
					//通过数据库中表UserRole，拿到了与userId对应的roleId，此时应该到数据库表Role中拿到与roleId所对应的相关详细信息
					//List<Role> roleList = roleService.getRolesById(roleIdList);
					List<Role> roleList2 = new ArrayList<>();
					for (Integer id : roleIdList) {
							Role role = roleMapper.selectById(id);
							roleList2.add(role);
					}
					//将所查询出的详细角色信息再添加回oneUser2Nroles的List<Role>集合中
					oneUser2NRoles.setRoles(roleList2);
					//再将设置好的oneUser2NRoles对象再添加回集合listOneUser2NRoles中
					listOneUser2NRoles.add(oneUser2NRoles);
			}
			return listOneUser2NRoles;
		/*//思路：1).新建一个OneUser2NRoless集合去接收
		List<OneUser2NRoles> oneUser2NRoles = new ArrayList<>();
		//2).拿到所有的user
		listUser().stream().map(x->x.getId()).map(x->)*/
		
	}
	
	
	@Override
	public List<User> getUsersByIds(List<Integer> userIds) {
		List<User> userList=new ArrayList<>();
		for (Integer id : userIds) {
			User user = userMapper.selectById(id);
			userList.add(user);
			
		}
		return userList;
	}
	/**
	 * @Transactional :update insert delete
	 */
	
	
	
	//添加用户
	@Override
	public int add(User user){
		int id =userMapper.insert(user);
		return id;
	}
	
	//修改用户
	@Override
	public int update(User user){
		//自己了解 updateById为什么可以直接传进来user
		// int updateById(@Param("et") T entity);
		int id =userMapper.updateById(user);
		return id;
	}
	
	//删除用户
	@Override
	public int delete(int id){
		return userMapper.deleteById(id);
	}
	

}