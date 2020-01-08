package com.lichuachua.blog.blogserver.exception;


import com.lichuachua.blog.blogserver.enums.ErrorCodeEnum;

public class UserException extends BaseException {

    public UserException(int code, String message) {
        super(code, message);
    }

    public UserException(ErrorCodeEnum codeEnum, Object... args) {
        super(codeEnum, args);
    }
}
