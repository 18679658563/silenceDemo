package com.silence.system.entity;

import lombok.Data;

import javax.persistence.*;

/***
 * Created with IntelliJ IDEA.
 * Description: 组织结构
 * User: silence
 * Date: 2019-12-09
 * Time: 上午10:43
 */
@Table(name = "base_org")
@Data
public class Org {

    private String name;

    /**
     * 编码  唯一校验
     */
    private String code;

    /**
     * 层级编码
     */
    @Column(name = "level_code")
    private String levelCode;

    /**
     * 数据字典ID
     */
    @Column(name = "org_type")
    private String orgType;

    /**
     * Y删除 N不删除
     */
    private String deleted;

    /**
     * 备注
     */
    private String note;

    /**
     * 上级ID
     */
    private String parentid;

    private String lspell;
    private String initials;
    private String uspell;
}
