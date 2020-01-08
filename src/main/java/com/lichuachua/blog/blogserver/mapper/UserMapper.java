package com.lichuachua.blog.blogserver.mapper;

import com.lichuachua.blog.blogserver.entity.User;
import com.lichuachua.blog.blogserver.form.UserLoginForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User login(UserLoginForm userLoginForm);

    void register(User user);


    User findByMobile(String mobile);



    User queryUserByMoBile();
}
