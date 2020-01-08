package com.lichuachua.blog.blogserver.service.impl;

import com.lichuachua.blog.blogserver.form.UserRegisterForm;
import com.lichuachua.blog.common.enums.UserStatusEnum;
import com.lichuachua.blog.common.util.NickNameUtil;
import com.lichuachua.blog.common.util.TokenUtil;
import com.lichuachua.blog.blogserver.dto.TokenInfo;
import com.lichuachua.blog.blogserver.enums.ErrorCodeEnum;
import com.lichuachua.blog.blogserver.exception.UserException;
import com.lichuachua.blog.blogserver.form.UserLoginForm;
import com.lichuachua.blog.blogserver.mapper.UserMapper;
import com.lichuachua.blog.blogserver.entity.User;
import com.lichuachua.blog.blogserver.repository.IRedisRepository;
import com.lichuachua.blog.blogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private IRedisRepository redisRepository;


    @Override
    public void register(UserRegisterForm userRegisterForm) {
        User user1 = userMapper.findByMobile(userRegisterForm.getMobile());
        System.out.println(user1);
        if (user1 != null) {
            throw new UserException(ErrorCodeEnum.MOBILE_REGISTERED);
        }
        /**
         * 检查两次密码是否相同
         */
        if (!userRegisterForm.getPassword().equals(userRegisterForm.getConfirmPassword())) {
            throw new UserException((ErrorCodeEnum.TWO_PASSWORD_NO_EQUALS));
        }

        /**
         *  保存用户信息到数据库，完成注册
         */
        User user = new User();
        user.setMobile(userRegisterForm.getMobile());
        user.setUserId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        user.setPassword(userRegisterForm.getPassword());
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        user.setStatus(UserStatusEnum.NORMAL.getStatus());
        user.setNickName(NickNameUtil.genNick());
        userMapper.register(user);
    }


    @Override
    public TokenInfo login(UserLoginForm userLoginForm) {
        /**
         * 查找用户
         */
        User user = userMapper.login(userLoginForm);
        System.out.println(user);
        if (user==null) {
            throw new UserException(ErrorCodeEnum.PASSWORD_ERROR);
        }
        /**
         * 生成accessToken
         */
        String accessToken = TokenUtil.genToken();

        /**
         * 将accessToken和用户信息存入Redis ，并删除旧的Token
         */
        String userId = user.getUserId();
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setUserId(userId);
        tokenInfo.setAccessToken(accessToken);


        //获取旧的Token并删除，---------通知客户端在其他地方登录
        String olderAccessToken = redisRepository.findAccessTokenByUserId(userId);
        if (null !=olderAccessToken){
            //TODO  通知客户端在其他地方登录
            //删除旧的Token
            redisRepository.deleteAccessToken(olderAccessToken);
        }

        //保存新的Token，更新当前用户使用的Token
        redisRepository.saveAccessToken(tokenInfo);
        redisRepository.saveUserAccessToken(userId,accessToken);
        /*
          5.返回登录结果
         */
        return tokenInfo;
    }



}
