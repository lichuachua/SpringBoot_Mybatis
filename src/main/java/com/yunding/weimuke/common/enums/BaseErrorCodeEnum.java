package com.yunding.weimuke.common.enums;


import lombok.Getter;

@Getter
public enum  BaseErrorCodeEnum {
    /**
     * 系统繁忙
     */
    UN_KNOW_EXCEPTION(1000, "系统繁忙，请稍后再试"),

    /**
     * Json转换异常
     */
    JSON_TRANS_ERROR(1000, "JSON转换出错"),

    /**
     * 用户前端传过来的参数不合法
     */
    PARAM_ERROR(1001, "参数错误:%s"),

    /**
     * 查找不到登录的用户
     */
    NO_USER_INFO_FOUND(1002, "获取不到当前用户")
    ;


    BaseErrorCodeEnum(Integer code, String message) {
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
