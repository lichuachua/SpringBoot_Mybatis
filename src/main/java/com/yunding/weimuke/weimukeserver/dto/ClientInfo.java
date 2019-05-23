package com.yunding.weimuke.weimukeserver.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 段启岩
 */
@Data
public class ClientInfo implements Serializable {

    private String accessToken;

    private String userId;

    private Long mostSignBits;

    private Long leastSignBits;

}
