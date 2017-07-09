package com.bili.finacialSystem.role.service;

import com.bili.finacialSystem.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bili on 2017/7/9.
 */
@Transactional
public interface RoleRepository extends JpaRepository<Role,String> {
   @Query("update Role set delMark=true where id=:id")
   @Modifying
    void delRole(@Param("id") String id);

}
