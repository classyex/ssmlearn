package com.github.classyex.web.util;

/**
 * Created by yex on 16-10-10.
 */
public class ResponseObj<T> {

    public static final int FAILED = 0;
    public static final int OK = 1;
    public static final int EMPTY = 2;
    public static final String OK_STR = "ok";
    private int code;
    private String msg;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
