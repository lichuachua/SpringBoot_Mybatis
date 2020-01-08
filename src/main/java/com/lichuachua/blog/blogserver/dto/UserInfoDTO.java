package com.lichuachua.blog.blogserver.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfoDTO implements Serializable {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String userAvatar;


    /**
     * 注册时间
     */
    private Date createdAt;



}
