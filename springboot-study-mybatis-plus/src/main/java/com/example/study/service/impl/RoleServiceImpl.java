package com.example.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.demo.OneRoles2NUser;
import com.example.study.demo.Role;
import com.example.study.demo.User;
import com.example.study.mapper.RoleMapper;
import com.example.study.service.RoleService;
import com.example.study.service.UserRoleService;
import com.example.study.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
//为什么在ServiceImpl层延申Mapper？todo 本来是可以写可以不写的，也就是说这一块可以直接去掉ServiceImpl<RoleMapper, Role>
//并不会对功能产生实际的收益
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    
    @Resource
    private RoleMapper      roleMapper;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private UserService userService;
    
    @Override
    public List<Role> listRole() {
      
        return roleMapper.selectList(null);
    }
    
    @Override
    public List<OneRoles2NUser> getRolesUser() {
        //1.拿到role的集合
        List<Role> roleList = listRole();
        //2.设置一个listOneRoles2NUser去接收
        List<OneRoles2NUser> oneRoles2NUsers = new ArrayList<>();
        //3.遍历for的集合
        for (Role role1 : roleList) {
            Integer roleId = role1.getId();
            //新建一个NRoles2OneUser对象
            OneRoles2NUser oneRoles2NUser = new OneRoles2NUser();
            //将遍历的每个角色Id传给OneROles2NUser
            oneRoles2NUser.setId(roleId);
            //将遍历的每个角色名称传给OneROles2NUser
            oneRoles2NUser.setRoleName(role1.getRoleName());
            //通过roleId 获取userIdList
            //通过UserRoleService层中的getUserIdListByRoleId方法拿到userIdList   ???
            List<Integer> userIdList = userRoleService.getUserIdListByRoleId(roleId);
            //通过userIdList获取users
            List<User> users = userService.getUsersByIds(userIdList);
            //将List<User>传进oneRoles2NUsers
            oneRoles2NUser.setUsers(users);
            //添加一个对象
            oneRoles2NUsers.add(oneRoles2NUser);
            
        }
        return oneRoles2NUsers;
    }
    
    @Override
    public List<Role> getRolesById(List<Integer> roleIdList){
        //新建一个对象Role的集合
        List<Role> roleList = new ArrayList<>();
        //遍历所传进来的roleIdList的值
        for (int id:roleIdList){
            //遍历的每条结果是id，所以通过selectById（）的方法查询出角色
            Role role = roleMapper.selectById(id);
            roleList.add(role);
        }
        return roleList;
    }
    
    //添加一个用户
    @Override
    public int add(Role role) {
        //添加一个用户返回的是一条数据，所以用int接收
        return roleMapper.insert(role);
    }
    
    //2.删除一个用户
    @Override
    public int delete(int id){
        //删除一个用户所返回的是执行一条数据1，所以用int接收
        return roleMapper.deleteById(id);
    }
    
    //3.修改一个用户
    @Override
    public int update(Role role){
        //修改一个用户所返回的是执行一条数据1，所以用int接收
        return roleMapper.updateById(role);
    }
}