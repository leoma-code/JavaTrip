package com.leo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Leo on 2020/4/2.
 * Description :
 */

@Entity
@Table(name = "sys_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;


    /**
     * 配置多对多的映射关系
     *      1、声明表关系的配置
     *          @ManyToMany(targetEntity = User.class)
     *              targetEntity：代表对方的实体类字节码
     *      2、配置中间表（包含两个外键）
     *          @JoinTable
     *              name 中间表的名称
     *              joinColumns 配置当前对象在中间表中的外键
     *                  name 外键名
     *                  referencedColumnName 参照主表的主键名
     *              inverseJoinColumns 配置对方对象在中间表的外键
     */
//    @ManyToMany(targetEntity = User.class)
//    @JoinTable(name = "sys_user_role",
//            joinColumns = {@JoinColumn(name = "sys_role_id", referencedColumnName = "role_id")},
//            inverseJoinColumns = {@JoinColumn(name = "sys_user_id", referencedColumnName = "user_id")}
//    )
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>();


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", users=" + users +
                '}';
    }
}
