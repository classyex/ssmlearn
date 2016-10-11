package com.github.classyex.web.exception;

/**
 * 用户操作其他异常
 * Created by yex on 16-10-10.
 */
public class OtherThingsException extends Exception {
    public OtherThingsException(String message) {
        super(message);
    }

    public OtherThingsException(Exception e) {
        super(e);
    }
}
