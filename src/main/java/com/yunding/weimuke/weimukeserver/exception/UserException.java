package com.yunding.weimuke.weimukeserver.exception;


import com.yunding.weimuke.weimukeserver.enums.ErrorCodeEnum;

public class UserException extends BaseException {

    public UserException(int code, String message) {
        super(code, message);
    }

    public UserException(ErrorCodeEnum codeEnum, Object... args) {
        super(codeEnum, args);
    }
}
