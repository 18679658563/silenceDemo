package com.silence.common.response;

import lombok.Data;

/***
 * Created with IntelliJ IDEA.
 * Description:
 * User: silence
 * Date: 2019-12-06
 * Time: 上午9:35
 */
@Data
public class BaseResponse {

    private int status=200;
    private String message;

    public BaseResponse(int status,String message){
        this.status=status;
        this.message=message;
    }

    public BaseResponse(){

    }
}
