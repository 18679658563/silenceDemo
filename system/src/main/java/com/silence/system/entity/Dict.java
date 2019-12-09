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
 * Time: 上午11:05
 */
@Data
@Table(name = "base_dict")
public class Dict extends BaseEntity {

    private String code;

    private String name;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "level_code")
    private String levelCode;

    private String enabled;

    private String description;

    private String value;

    private String lspell;

    private String uspell;

    private String initials;
}
