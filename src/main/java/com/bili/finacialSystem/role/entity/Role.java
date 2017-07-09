package com.bili.finacialSystem.role.entity;

import com.bili.finacialSystem.User.entity.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by bili on 2017/7/9.
 */
@Entity
@Table(name = "fs_role")
public class Role {
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    private String id;
    @Column(name = "name_")
    private String name;
    @Column(name="del_mark_")
    private Boolean delMark;
    @ManyToMany
    @JoinColumn(name = "user_id_")
    private Set<User> userSet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Boolean getDelMark() {
        return delMark;
    }

    public void setDelMark(Boolean delMark) {
        this.delMark = delMark;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userSet=" + userSet +
                '}';
    }
}
