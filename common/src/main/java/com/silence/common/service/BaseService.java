package com.silence.common.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.silence.common.response.TableResultResponse;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import com.silence.common.util.EntityUtil;
import com.silence.common.util.Query;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-12-06
 * Time: 上午9:27
 */
public abstract class BaseService<M extends Mapper<T>, T> {

    @Autowired
    protected M mapper;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public M getMapper(){
        return this.mapper;
    }

    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }


    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }


    public List<T> selectListAll() {
        return mapper.selectAll();
    }


    public Long selectCount(T entity) {
        return new Long(mapper.selectCount(entity));
    }


    public void insert(T entity) {
        EntityUtil.setCreateInfo(entity);
        mapper.insert(entity);
    }

    public void insert(List<T> entitys) {
        if (entitys != null && !entitys.isEmpty()) {
            for (T t:entitys) this.insert(t);
        }
    }


    public void insertSelective(T entity) {
        EntityUtil.setCreateInfo(entity);
        mapper.insertSelective(entity);
    }

    public void insertSelective(List<T> entitys) {
        if (entitys != null && !entitys.isEmpty()) {
            for (T t:entitys) this.insertSelective(t);
        }
    }

    public void delete(T entity) {
        mapper.delete(entity);
    }


    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
    }


    public void updateById(T entity) {
        EntityUtil.setUpdatedInfo(entity);
        mapper.updateByPrimaryKey(entity);
    }


    public void updateSelectiveById(T entity) {
        EntityUtil.setUpdatedInfo(entity);
        mapper.updateByPrimaryKeySelective(entity);

    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }

    public TableResultResponse<T> selectByQuery(Query query) {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        for (Map.Entry<String, Object> entry : query.entrySet()) {
            criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
        }
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<T> list = mapper.selectByExample(example);
        return new TableResultResponse(result.getTotal(), list);
    }
}