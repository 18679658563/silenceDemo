package com.silence.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.silence.common.response.ObjectResultResponse;
import com.silence.common.response.TableResultResponse;
import com.silence.common.service.BaseService;
import com.silence.common.util.Query;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-12-06
 * Time: 上午9:47
 */
public class BaseController<Service extends BaseService, Entity>  {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected Service baseService;

    @PostMapping(value = "/add")
    public ObjectResultResponse<Entity> add(@RequestBody Entity entity) {
        baseService.insertSelective(entity);
        return new ObjectResultResponse<Entity>().rel(true);
    }

    @GetMapping(value = "/get/{id}")
    public ObjectResultResponse<Entity> get(@PathVariable String id) {
        return new ObjectResultResponse<Entity>().rel(true).data(baseService.selectById(id));
    }

    @PutMapping(value = "/put/{id}")
    public ObjectResultResponse<Entity> update(@RequestBody Entity entity) {
        baseService.updateSelectiveById(entity);
        return new ObjectResultResponse<Entity>().rel(true);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ObjectResultResponse<Entity> remove(@PathVariable String id) {
        baseService.deleteById(id);
        return new ObjectResultResponse<Entity>().rel(true);
    }

    @GetMapping(value = "/all")
    public List<Entity> all() {
        return baseService.selectListAll();
    }

    @GetMapping(value = "/page")
    public TableResultResponse<Entity> page(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        return baseService.selectByQuery(query);
    }

}
