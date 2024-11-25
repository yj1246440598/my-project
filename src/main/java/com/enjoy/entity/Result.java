package com.enjoy.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final ResponseCode SUCCESS = ResponseCode.SUCCESS;
    private static final ResponseCode ERROR = ResponseCode.ERROR;

    // 编码：0表示成功，其他值表示失败
    private int code = SUCCESS.getCode();
    // 消息内容
    private String msg = SUCCESS.getMessage();
    // 响应数据
    private T data;
    
    /**
     * 返回错误的结果集
     */
    public static Result<Void> error(Exception e) {
        Result<Void> result = new Result<>();
        result.setCode(ERROR.getCode());
        result.setMsg(e.getMessage());
        return result;
    }

    /**
     * 返回错误的结果集
     */
    public static Result<Void> error(String e) {
        Result<Void> result = new Result<>();
        result.setCode(ERROR.getCode());
        result.setMsg(e);
        return result;
    }
    
    /**
     * 返回成功的结果集
     */
    public static Result<Void> success(String msg) {
        Result<Void> result = new Result<>();
        result.setCode(SUCCESS.getCode());
        result.setMsg(msg);
        return result;
    }
    
    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }

}
