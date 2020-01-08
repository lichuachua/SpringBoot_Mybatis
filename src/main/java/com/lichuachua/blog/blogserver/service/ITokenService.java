package com.lichuachua.blog.blogserver.service;

import com.lichuachua.blog.blogserver.dto.TokenInfo;

public interface ITokenService {

    /**
     * 从Redis获取token的信息
     * @param accessToken
     * @return
     */
    TokenInfo getTokenInfo(String accessToken);

}
