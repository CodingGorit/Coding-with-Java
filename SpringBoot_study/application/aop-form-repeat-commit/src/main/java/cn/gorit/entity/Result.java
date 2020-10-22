package cn.gorit.entity;



import java.io.Serializable;

/**
 * @Classname Result
 * @Description 统一返回结果集
 * @Date 2020/9/21 15:19
 * @Created by CodingGorit
 * @Version 1.0
 */
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }



}
