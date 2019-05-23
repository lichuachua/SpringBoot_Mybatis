package com.yunding.weimuke.weimukeserver.service.impl;

import com.yunding.weimuke.weimukeserver.dto.TokenInfo;
import com.yunding.weimuke.weimukeserver.repository.IRedisRepository;
import com.yunding.weimuke.weimukeserver.service.ITokenService;
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
