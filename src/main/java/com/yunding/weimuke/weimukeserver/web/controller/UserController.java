package com.yunding.weimuke.weimukeserver.web.controller;

import com.yunding.weimuke.core.support.web.controller.BaseController;
import com.yunding.weimuke.weimukeserver.dto.TokenInfo;
import com.yunding.weimuke.weimukeserver.dto.UserInfoDTO;
import com.yunding.weimuke.weimukeserver.form.UserLoginForm;
import com.yunding.weimuke.weimukeserver.service.UserService;
import com.yunding.weimuke.weimukeserver.entity.User;
import com.yunding.weimuke.weimukeserver.wrapper.ResultWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
        TokenInfo tokenInfo = userService.auth(userLoginForm);
        /**
         * 返回token
         */
        return ResultWrapper.successWithData(tokenInfo);

    }

    @RequestMapping("/showUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return user;
    }



}
