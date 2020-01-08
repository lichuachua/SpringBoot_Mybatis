package com.lichuachua.blog.blogserver.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private String userId;

    private String mobile;

    private String password;

    private String nickName;

    private String userAvatar;

    private Integer status;

    private Date createdAt;

    private Date updatedAt;

}
