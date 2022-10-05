package com.example.springbootstudyjpa;

import com.example.springbootstudyjpa.pojo.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.internal.Function;

@SpringBootTest
class SpringbootStudyJpaApplicationTests {
    
    @Test
    void contextLoads() {
    }
    
    //1.group by
    @Test
    void groupBy() {
        List<Role> groupList = new ArrayList<>();
        groupList.add(Role.builder().roleName("zhangsan").id(1).build());
        groupList.add(Role.builder().roleName("zhangsan").id(2).build());
        groupList.add(Role.builder().roleName("zhangsan").id(3).build());
        groupList.add(Role.builder().roleName("zhangsan").id(5).build());
        groupList.add(Role.builder().roleName("zhangsan1").id(1).build());
        groupList.add(Role.builder().roleName("zhangsan1").id(2).build());
        groupList.add(Role.builder().roleName("zhangsan2").id(3).build());
        groupList.add(Role.builder().roleName("zhangsan3").id(5).build());
        //roleName 分组 select * from A group By roleName
        Map<String, List<Role>> roleName2ListRoleMap = groupList.stream()
                .collect(Collectors.groupingBy(role -> role.getRoleName()));
        System.out.println(roleName2ListRoleMap.keySet());
        //todo id key  group
        
        //todo  id key group value（原本 List<Role>） 此时我想用 List<String/*roleName*/> Collectors.groupingBy + Collectors.mapping+Collectors.toMap
        
    }
    
    @Test
    void map() {
        List<Role> groupList = new ArrayList<>();
        groupList.add(Role.builder().roleName("zhangsan").id(1).build());
        Map<String, Integer> roleName2RoleIdMap = groupList.stream()
                .collect(Collectors.toMap(role -> role.getRoleName(), role -> role.getId()));
        //todo id key  name value
        
        //todo  id key role value
        
        //map convert value list《getRoleName》 Collectors.toList
    }
    
    //
    @Test
    void Function() {
        //a+b
        int b = 1;
        Function<Integer/*a*/, Integer/*result*/> aFunction = a -> a + b;
        System.err.println(aFunction.apply(1));
        //todo  不需要外界给 B
        BiFunction<Integer, Integer, Integer> aAndBBiFunc = (a, c) -> a + c;
        //
        
    }
    
}