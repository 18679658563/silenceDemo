package com.silence.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/***
 * Created with IntelliJ IDEA.
 * Description: 实体类相关工具类
 *             解决问题： 1、快速对实体的常驻字段，如：createTime,createId,updateTime,updateId等值快速注入
 * User: silence
 * Date: 2019-12-06
 * Time: 上午8:40
 */
public class EntityUtil {

    /**
     * 快速将bean的createId、createTime附上相关值
     *
     * @param entity 实体bean
     */
    public static <T> void setCreateInfo(T entity) {
        // 默认属性
        String[] fields = {"id","createId", "createTime"};
        String createId = getUserId();
        Object[] values = new Object[]{UUIDUtil.getUUID(),createId,new Date()};
        // 填充默认属性值
        setDefaultValues(entity, fields, values);
    }

    /**
     * 快速将bean的updateUser、updateTime附上相关值
     *
     * @param entity 实体bean
     */
    public static <T> void setUpdatedInfo(T entity) {
        // 默认属性
        String[] fields = { "updateId",  "updateTime"};
        String updateId = getUserId();
        Object[] values = new Object[]{updateId,new Date()};
        // 填充默认属性值
        setDefaultValues(entity, fields, values);
    }

    public static String getUserId() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String id = "";
        if (request != null) {
            id = String.valueOf(request.getSession().getAttribute("userId"));
        }
        return id;
    }

    /**
     * 依据对象的属性数组和值数组对对象的属性进行赋值
     *
     * @param entity 对象
     * @param fields 属性数组
     * @param value  值数组
     */
    private static <T> void setDefaultValues(T entity, String[] fields, Object[] value) {
        for (int i = 0; i < fields.length; i++) {
            String field = fields[i];
            if (ReflectionUtil.hasField(entity, field)) {
                ReflectionUtil.invokeSetter(entity, field, value[i]);
            }
        }
    }


}
