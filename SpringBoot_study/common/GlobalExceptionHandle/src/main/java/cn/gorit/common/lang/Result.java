package cn.gorit.common.lang;

/**
 * 封装统一结果集返回数据
 * */
public class Result {
    private Object data;
    private String msg;
    private int code;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    // 操作成功返回数据
    public static Result succ(Object data) {
        return succ(200, "操作成功", data);
    }


    public static Result succ(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result succ(String msg, Object data) {
        return succ(200,msg,data);
    }

    // 操作异常返回
    public static Result fail(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result fail(String msg) {
        return fail(400,msg,null);
    }

    public static Result fail(int code, String msg) {
        return fail(code,msg,"null");
    }

    public static Result fail(String msg, Object data) {
        return fail(400,msg,data);
    }

}
