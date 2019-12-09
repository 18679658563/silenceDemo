package com.silence.system.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-12-06
 * Time: 下午3:45
 */
@Data
@Table(name = "base_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String username;

    private String password;

    private String name;

    private String header;

    private String birthday;

    private String address;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "tel_phone")
    private String telPhone;

    private String email;

    private String sex;

    private String type;

    private String status;

    private String description;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_name")
    private String createName;

    @Column(name = "create_host")
    private String createHost;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_name")
    private String updateName;

    @Column(name = "update_host")
    private String updateHost;

    @Transient
    private String corgId;
    @Transient
    private String corg;
}
