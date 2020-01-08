package com.lichuachua.blog.blogserver.service;

import com.lichuachua.blog.blogserver.dto.TokenInfo;
import com.lichuachua.blog.blogserver.entity.User;
import com.lichuachua.blog.blogserver.form.UserLoginForm;
import com.lichuachua.blog.blogserver.form.UserRegisterForm;

import javax.validation.Valid;
import java.util.List;

public interface UserService {
    TokenInfo login(@Valid UserLoginForm userLoginForm);

    void register(@Valid UserRegisterForm userRegisterForm);


    User queryUserByMoBile(@Valid String mobile);
}
