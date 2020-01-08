package com.lichuachua.blog.blogserver.service.impl;

import com.lichuachua.blog.blogserver.dto.TokenInfo;
import com.lichuachua.blog.blogserver.repository.IRedisRepository;
import com.lichuachua.blog.blogserver.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements ITokenService {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    private IRedisRepository redisRepository;

    @Override
    public TokenInfo getTokenInfo(String accessToken) {
        TokenInfo tokenInfo = redisRepository.findTokenInfoByAccessToken(accessToken);
        return tokenInfo;
    }

}
