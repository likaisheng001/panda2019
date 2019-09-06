package com.panda.exception;

/**
 * Created by Administrator on 2019/9/6.
 */
public class UserNotExistException extends RuntimeException{
    public UserNotExistException() {
        super("用户不存在");
    }
}
