package com.bili.finacialSystem.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户实体类
 * Created by bili on 2017/6/17.
 */
@Entity
@Table(name = "fs_user")
public class User {
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name = "id_",length=32)
    private String id; //用户id
    @Column(name="user_name_",length = 64)
    private String userName; //用户名
    @Column(name="password_")
    private String password; //密码
    @Column(name = "user_nike_name_")
    private String userNikeName; //昵称
    @Column(name = "last_login_time_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;  //最后登录时间
    @Column(name = "tel_",length = 32)
    private String tel; //联系电话
    @Column(name = "email_",length = 32)
    private String email; //邮箱
    @Column(name = "delmark_")
    private boolean delMark; //删除标记（true为删除）

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserNikeName() {
        return userNikeName;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserNikeName(String userNikeName) {
        this.userNikeName = userNikeName;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userNikeName='" + userNikeName + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
