package com.bili.finacialSystem.role.service;

import com.bili.finacialSystem.role.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bili on 2017/7/9.
 */
@Service("roleService")
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    /**
     * 新增角色
     * @param role
     * @return
     */
    public Role saveRole(Role role){
        role = roleRepository.save(role);
        return role;
    }

}
