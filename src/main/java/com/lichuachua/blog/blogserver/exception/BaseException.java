package com.lichuachua.blog.blogserver.exception;


import com.lichuachua.blog.common.enums.BaseErrorCodeEnum;
import com.lichuachua.blog.core.exception.SysException;
import com.lichuachua.blog.blogserver.enums.ErrorCodeEnum;

public class BaseException extends SysException {


    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(BaseErrorCodeEnum codeEnum, Object... args) {
        super(codeEnum, args);
    }

    public BaseException(ErrorCodeEnum codeEnum, Object... args) {
        super(String.format(codeEnum.getMessage(), args));
        this.code = codeEnum.getCode();
    }

}
