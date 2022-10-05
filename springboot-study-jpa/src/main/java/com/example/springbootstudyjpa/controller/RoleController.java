package com.example.springbootstudyjpa.controller;

import com.example.springbootstudyjpa.exception.BizException;
import com.example.springbootstudyjpa.pojo.Result;
import com.example.springbootstudyjpa.pojo.Role;
import com.example.springbootstudyjpa.pojo.Role2NUsers;
import com.example.springbootstudyjpa.service.RoleService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * {@link RequestMethod#GET} 获取一种对象 https://www.cnblogs.com/bigsai/p/14099154.html?a=1&b=1&c=1&d=1
 * {@link RequestMethod#POST} 新增一种对象、获取一种对象 (查询参数大于 5 个以上，要用 json 对象方式去请求（a b c d e f 需要这么多条件才可以拿到一条数据）)
 * {@link RequestMethod#PUT} 更新一种对象 （id name  a b）
 * {@link RequestMethod#DELETE} 删除一种对象
 * {@link PathVariable} 指的 url 拼接 /getRole/{id}
 * {@link RequestBody} 指的是 json
 * </pre>
 * 1. 添加 user 的同时添加 role，并且实现关联 adminA roleA 添加 adminA 的同时把 roleA 添加上去，然后 userROle 中有一条数据是关联 uid rid 思路写出来 user id admin
 * 1
 * <p>
 * role id role1 2
 * <p>
 * uid rid 1   2
 * <p>
 * 2. 添加 role 的同时添加 user，并且实现关联
 */
@RestController
@RequestMapping("role")
public class RoleController {
    @Resource
    RoleService roleService;
    
    /**
     * 根据 id 获取 role
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Role getRole(@PathVariable int id) {
        return roleService.getRoleInfo(id);
    }
    
    @RequestMapping(value = "/th/{id}", method = RequestMethod.GET)
    public Role getRoleEx(@PathVariable int id) throws BizException {
        throw new BizException("抛出");
    }
    
    /**
     * 根据 id 获取 role
     *
     * @return
     */
    @RequestMapping(value = "/l/{id}", method = RequestMethod.GET)
    public Result<Role> getRole1(@PathVariable int id) {
        
        return Result.<Role>builder().data(roleService.getRoleInfo(id)).build();
    }
    
    /**
     * 按角色名称查找 Repository 接口方法名称命名查询 /role-name/1 /role-name/2 /role-name/3
     *
     * @param name 名称
     * @return {@link List}<{@link Role}>
     */
    @RequestMapping(value = "/role-name/{name}", method = RequestMethod.GET)
    public List<Role> findByRoleName(@PathVariable("name") String name) {
        return roleService.findByRoleName(name);
    }
    
    @RequestMapping(value = "/role-name-like/{name}", method = RequestMethod.GET)
    public List<Role> findByRoleNameLike(@PathVariable("name") String name) {
        return roleService.findByRoleNameLike(name);
    }
    
    /**
     * 查询所有用户信息
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Role> getAllRole() {
        return roleService.getAllRole();
    }
    
    /**
     * 查询一个角色对应多个用户
     *
     * @return
     */
    @RequestMapping(value = "/one-role-n-users", method = RequestMethod.GET)
    public List<Role2NUsers> findRole2NUsers() {
        return roleService.findRole2NUsers();
    }
    
    /**
     * 根据指定 id 删除角色
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRoleInfo(@PathVariable int id) {
        roleService.deleteRole(id);
    }
    
    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Role addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }
    
    /**
     * 修改角色
     *
     * @param role
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void updateRole(@RequestBody Role role) {
        
        roleService.updateRole(role);
    }
    
}