package com.silence.system.entity;

import com.silence.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-12-09
 * Time: 上午10:47
 */
@Table(name = "base_element")
@Data
public class Element extends BaseEntity {

    /**
     * 资源编码
     */
    private String code;

    /**
     * 资源类型
     */
    private String type;

    /**
     * 资源名称
     */
    private String name;

    private String uri;

    /**
     * 资源关联菜单
     */
    @Column(name = "menu_id")
    private String menuId;

    /**
     * 资源请求类型
     */
    private String method;

    private String description;
}
