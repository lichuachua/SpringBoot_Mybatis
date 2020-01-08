package com.lichuachua.blog.blogserver.form;

import lombok.Data;

@Data
public class UserRegisterForm {
    private String mobile;

    private String password;

    private String confirmPassword;
}
