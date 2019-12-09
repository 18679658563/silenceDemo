package com.silence.system.entity;

import com.silence.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/***
 * Created with IntelliJ IDEA.
 * Description: 角色表
 * User: silence
 * Date: 2019-12-09
 * Time: 上午10:41
 */
@Data
@Table(name = "base_role")
public class Role extends BaseEntity {

    private String code;

    private String name;

    @Column(name = "parent_id")
    private String parentId;

    private String levelcode;

    private String type;

    private String enabled;

    private String description;

    @Transient
    private String parentName;
}
