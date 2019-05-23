package com.yunding.weimuke.weimukeserver.service.impl;

import com.yunding.weimuke.common.util.TokenUtil;
import com.yunding.weimuke.weimukeserver.dto.TokenInfo;
import com.yunding.weimuke.weimukeserver.enums.ErrorCodeEnum;
import com.yunding.weimuke.weimukeserver.exception.UserException;
import com.yunding.weimuke.weimukeserver.form.UserLoginForm;
import com.yunding.weimuke.weimukeserver.mapper.UserMapper;
import com.yunding.weimuke.weimukeserver.entity.User;
import com.yunding.weimuke.weimukeserver.repository.IRedisRepository;
import com.yunding.weimuke.weimukeserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private IRedisRepository redisRepository;


    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record){
        boolean result = false;
        try {
            userMapper.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public TokenInfo auth(UserLoginForm userLoginForm) {
        /**
         * 查找用户
         */
        User user = userMapper.queryUser(userLoginForm);
        if (user==null){
            throw new UserException(ErrorCodeEnum.PASSWORD_ERROR);
        }
                /*
          3.生成accessToken
         */
        String accessToken = TokenUtil.genToken();

        /*
          4.将accessToken和用户信息存储到Redis,并删除旧的accessToken
         */
        String userId = user.getId();

        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setUserId(user.getId());
        tokenInfo.setAccessToken(accessToken);

    // 保存新token,更新用户当前使用的token
        redisRepository.saveAccessToken(tokenInfo);
        redisRepository.saveUserAccessToken(userId, accessToken);

        /*
          5.返回登录结果
         */
        return tokenInfo;

    }



}
