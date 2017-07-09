package com.bili.finacialSystem.role.service;

import com.bili.finacialSystem.User.entity.User;
import com.bili.finacialSystem.role.entity.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by bili on 2017/7/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RoleRepositoryTest {
    @Autowired
    private RoleRepository repository;
    @Resource(name = "roleService")
    private RoleService roleService;

    /**
     * 新增一条数据，然后逻辑删除
     */
    @Test
    public void testDel(){
        Role role=new Role();
        role.setName("test2");
        role.setDelMark(false);
        role=repository.save(role);

        repository.delRole(role.getId());
        Assert.assertNotEquals(true,role.getDelMark());
    }
    /**
     * roleSave方法测试新增数据
     */
    @Test
    public void testAdd(){
        Role role=new Role();
        role.setName("test5");
        role.setDelMark(false);
        role=repository.save(role);
        Assert.assertNotNull(role.getId());
    }
    /**
     * roleSave方法测试修改数据
     */
    @Test
    public void testUpdate(){
        //设置USER
        Set users = new HashSet<User>();
        User user = new User();
        user.setId("402880f55cba4057015cba40750a0000");
        users.add(user);
        //修改对应关系
        Role role=repository.findOne("402880ec5d268099015d2680b4ad0000");
        role.setName("啊啊啊");
        role.setUserSet(users);
        repository.save(role);
        Assert.assertNotNull(role.getUserSet());
        Assert.assertEquals("啊啊啊",role.getName());
    }
}