package com.silence.common.response;

import lombok.Data;

import java.util.List;

/***
 * Created with IntelliJ IDEA.
 * Description: 分页集合类
 * User: silence
 * Date: 2019-12-06
 * Time: 上午9:37
 */
@Data
public class TableResultResponse<T> extends BaseResponse {

    long total;
    List<T> rows;

    public TableResultResponse(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

}
