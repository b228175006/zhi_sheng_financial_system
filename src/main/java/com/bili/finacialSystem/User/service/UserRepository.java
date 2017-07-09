package com.bili.finacialSystem.User.service;

import com.bili.finacialSystem.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户Service接口
 * Created by bili on 2017/6/17.
 */
@Transactional
public interface UserRepository extends JpaRepository<User,String>{

    /**
     * 根据用户名模糊查询User
     * @param userName 用户名
     * @return
     */
    User findByUserNameLike(String userName);

    /**
     * 根据UserId查询用户
     * @param userId 用户Id
     * @return
     */
    User findById(String userId);

    /**
     * 根据用户名和密码获取用户
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    User findByUserNameAndPassword(String userName,String password);

    /**
     * 根据用户ID逻辑删除用户
     * @param userId 用户ID
     * @return
     */
    @Query("update User set delMark = true where id=:userId")
    @Modifying
    void delUser(@Param("userId") String userId);



}
