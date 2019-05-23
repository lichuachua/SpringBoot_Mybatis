package com.yunding.weimuke.weimukeserver.exception;


import com.yunding.weimuke.common.enums.BaseErrorCodeEnum;
import com.yunding.weimuke.core.exception.SysException;
import com.yunding.weimuke.weimukeserver.enums.ErrorCodeEnum;

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
