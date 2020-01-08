package com.lichuachua.blog.blogserver.entity;

import lombok.Data;
import java.util.Date;

/**
 * @author 李歘歘
 */
@Data
public class User {


    private String userId;

    private String mobile;

    private String password;

    private String nickName;

    private String userAvatar;

    private Integer status;

    private Date createdAt;

    private Date updatedAt;


}
