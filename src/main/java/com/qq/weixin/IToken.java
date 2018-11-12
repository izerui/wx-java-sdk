package com.qq.weixin;

import com.qq.weixin.mappings.AccessToken;

public interface IToken {

    // 获取appId对应的secret秘钥
    String getSecret(String appId);

    // 获取token
    String getToken(String appId);

    // 更新缓存中的token
    void updateToken(String appId, AccessToken token);

    // 根据appId删除缓存的token
    void deleteToken(String appId);

}
