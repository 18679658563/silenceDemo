package com.silence.system.entity;

import com.silence.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/***
 * Created with IntelliJ IDEA.
 * Description: y用户表
 * User: silence
 * Date: 2019-12-06
 * Time: 下午3:45
 */
@Data
@Table(name = "base_user")
public class User extends BaseEntity {

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

    @Transient
    private String corgId;
    @Transient
    private String corg;
}
