package com.hngc.utils;

/**
 * 统一返回结果类
 */
public class Result {
    //描述统一格式中的数据
    private Object data;
    //操作状态吗
    private Integer code;
    //描述统一格式中的消息，可选属性
    private String msg;

    public Result() {
    }

    public Result(Integer code) {
        this.code = code;
    }

    //构造方法是方便对象的创建
    public Result(Integer code, Object data) {
        this.data = data;
        this.code = code;
    }

    public Result(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    //构造方法是方便对象的创建
    public Result(Integer code, Object data, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Result success() {
        this.code = Code.SUCCESS;
        return this;
    }

    public Result error(String msg) {
        this.code = Code.ERROR;
        this.msg = msg;
        return this;
    }

    public Result data(Object obj) {
        this.data = obj;
        return this;
    }

    public String toString() {
        return "Result{data = " + data + ", code = " + code + ", msg = " + msg + "}";
    }


    /**
     * 获取
     *
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置
     *
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 获取
     *
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置
     *
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取
     *
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}