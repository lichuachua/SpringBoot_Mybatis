package com.yunding.weimuke.weimukeserver.service;

import com.yunding.weimuke.weimukeserver.dto.TokenInfo;
import com.yunding.weimuke.weimukeserver.entity.User;
import com.yunding.weimuke.weimukeserver.form.UserLoginForm;

import javax.validation.Valid;

public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);


    TokenInfo auth(@Valid UserLoginForm userLoginForm);

}
