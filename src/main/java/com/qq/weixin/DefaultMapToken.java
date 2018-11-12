package com.qq.weixin;

import com.qq.weixin.mappings.AccessToken;

import java.util.HashMap;
import java.util.Map;

public class DefaultMapToken implements IToken {

    // key: appId
    // value: secret
    private Map<String, String> configs = new HashMap<>();

    // key: appId
    // value: token
    private Map<String, String> tokens = new HashMap<>();

    // key: token
    // value: 时间戳
    private Map<String, Long> timeout = new HashMap<>();

    public DefaultMapToken(Map<String, String> appSecretsMap) {
        configs.putAll(appSecretsMap);
    }

    @Override
    public String getToken(String appId) {
        String token = tokens.get(appId);
        if (token != null) {
            Long tokenTime = timeout.get(token);
            // token 有效期1个小时
            if (System.currentTimeMillis() - tokenTime > 3600000) {
                deleteToken(appId);
                return null;
            }
        }
        return token;
    }

    @Override
    public void updateToken(String appId, AccessToken token) {
        tokens.put(appId, token.getAccessToken());
        timeout.put(token.getAccessToken(), token.getTokenTimeMillis());
    }

    @Override
    public void deleteToken(String appId) {
        String token = tokens.remove(appId);
        timeout.remove(token);

    }

    @Override
    public String getSecret(String appId) {
        return configs.get(appId);
    }

}