package com.silence.common.response;

import lombok.Data;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-12-06
 * Time: 上午9:49
 */
@Data
public class ObjectResultResponse<T> extends BaseResponse {

    T data;
    boolean rel;

    public ObjectResultResponse rel(boolean rel) {
        this.setRel(rel);
        return this;
    }


    public ObjectResultResponse data(T data) {
        this.setData(data);
        return this;
    }
}
