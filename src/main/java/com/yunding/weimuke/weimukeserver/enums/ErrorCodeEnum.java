package com.yunding.weimuke.weimukeserver.enums;

import lombok.Getter;

@Getter
public enum  ErrorCodeEnum {
    /**
     * 手机号已经被注册
     */
    MOBILE_REGISTERED(1111, "该手机号已被注册"),

    /**
     * 手机号还没注册成为系统的账号
     */
    MOBILE_NOT_REGISTERED(1111, "该手机号还未注册"),

    /**
     * 用户密码错误
     */
    PASSWORD_ERROR(1111, "密码错误"),

    /**
     * 用户的朋友圈为空
     */
    CIRCLE_NULL(1111,"待发布"),
    BAD_ACCESS_TOKEN(1201, "错误的token"),
    UNAUTHORIZED(1201, "未认证"),


    /**
     * 查不到好友关系
     */
    NONE_FRIEND(1111,"不存在该好友关系");


    ErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;


}
