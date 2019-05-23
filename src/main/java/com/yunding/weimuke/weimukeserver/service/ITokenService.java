package com.yunding.weimuke.weimukeserver.service;

import com.yunding.weimuke.weimukeserver.dto.TokenInfo;

public interface ITokenService {

    /**
     * 从Redis获取token的信息
     * @param accessToken
     * @return
     */
    TokenInfo getTokenInfo(String accessToken);

}
