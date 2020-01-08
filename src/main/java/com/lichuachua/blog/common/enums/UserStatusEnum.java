package com.lichuachua.blog.common.enums;

import lombok.Getter;

/**
 * @author 李歘歘
 * 用户状态类
 */
@Getter
public enum UserStatusEnum {
    /**
     * 用户正常
     */
    NORMAL(0,"正常"),

    /**
     * 用户被系统禁用封号
     */
    DISABLED(-1,"禁用"),

    /**
     * 用户被删除
     */
    DELETED(1,"删除");

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 用户状态描述
     */
    private String desc;

    UserStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
