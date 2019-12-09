package com.silence.system.entity;

import com.silence.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
/***
 * Created with IntelliJ IDEA.
 * Description: 菜单
 * User: silence
 * Date: 2019-12-09
 * Time: 上午10:45
 */
@Table(name = "base_menu")
@Data
public class Menu extends BaseEntity {

    /**
     * 标题
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 菜单上下级关系
     */
    private String levelcode;

    /**
     * 父级节点
     */
    @Column(name = "parent_id")
    private String parentId = "-1";

    /**
     * 资源路径
     */
    private String href;

    /**
     * 前端组件
     */
    private String component;

    /**
     * 图标
     */
    private String icon;

    private String type;

    /**
     * 描述
     */
    private String description;

    /**
     * 启用禁用
     */
    private String enabled;

    @Transient
    private String parentName;

}
