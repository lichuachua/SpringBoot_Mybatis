package com.yunding.weimuke.weimukeserver.repository;
import com.yunding.weimuke.weimukeserver.dto.ClientInfo;
import com.yunding.weimuke.weimukeserver.dto.TokenInfo;

import java.util.List;

/**
 * @author 段启岩
 */
public interface IRedisRepository {

    /**
     * 保存手机号和验证码的对应信息
     */
    void saveVerificationCode(String phoneNumber, String verification);

    /**
     * 根据手机号查询token
     * @param phoneNumber
     * @return
     */
    String findVerificationCodeByMoble(String phoneNumber);

    /**
     * 删除手机号和验证码的对应关系
     * @param phoneNumber
     */
    void deleteVerificationCode(String phoneNumber);

    /**
     * 保存token信息
     * @param tokenInfo
     */
    void saveAccessToken(TokenInfo tokenInfo);

    /**
     * 保存用户和token的对应信息
     * @param userId
     * @param accessToken
     */
    void saveUserAccessToken(String userId, String accessToken);

    /**
     * 根据用户ID查询token
     * @param userId
     * @return
     */
    String findAccessTokenByUserId(String userId);

    /**
     * 根据token查询token详情
     * @param accessToken
     * @return
     */
    TokenInfo findTokenInfoByAccessToken(String accessToken);

    /**
     * 删除token
     * @param accessTToken
     */
    void deleteAccessToken(String accessTToken);

    /**
     * 删除用户和token的对应关系
     * @param userId
     */
    void deleteUserAccessToken(String userId);

    /**
     * 保存连接进来的客户端连接信息
     * @param userId
     * @param clientInfo
     */
    void saveClientInfo(String userId, ClientInfo clientInfo);

    /**
     * 删除客户端连接信息
     * @param userId
     */
    void deleteClientInfo(String userId);

    /**
     * 根据用户ID从Redis查询客户端连接信息
     * @param userId
     * @return
     */
    ClientInfo findClientInfoByUserId(String userId);



    /**
     * 删除离线消息
     * @param userId
     */
    void deleteOfflineMessage(String userId);
}
