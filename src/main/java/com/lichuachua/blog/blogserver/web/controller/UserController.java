package com.lichuachua.blog.blogserver.web.controller;

import com.lichuachua.blog.blogserver.form.UserRegisterForm;
import com.lichuachua.blog.core.support.web.controller.BaseController;
import com.lichuachua.blog.blogserver.dto.TokenInfo;
import com.lichuachua.blog.blogserver.dto.UserInfoDTO;
import com.lichuachua.blog.blogserver.form.UserLoginForm;
import com.lichuachua.blog.blogserver.service.UserService;
import com.lichuachua.blog.blogserver.wrapper.ResultWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


@Api(value = "UserController", tags = {"用户API"})
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController<UserInfoDTO> {

    @Resource
    private UserService userService;


    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ResultWrapper<TokenInfo> login(
            @Valid @RequestBody UserLoginForm userLoginForm,
            BindingResult bindingResult){
        /**
         * 参数验证
         */
        validateParams(bindingResult);
        /**
         * 登录
         */
        TokenInfo tokenInfo = userService.login(userLoginForm);
        /**
         * 返回token
         */
        return ResultWrapper.successWithData(tokenInfo);
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public ResultWrapper register(@Valid UserRegisterForm userRegisterForm,
                                  BindingResult bindingResult){
        /**
         * 验证参数
         */
        validateParams(bindingResult);
        /***
         * 注册
         */
        userService.register(userRegisterForm);

        return ResultWrapper.success();
    }
}
