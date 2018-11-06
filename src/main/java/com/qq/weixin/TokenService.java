
package com.qq.weixin;

import com.qq.weixin.mappings.AccessToken;

/**
 * Created by serv on 16/4/20.
 */
public interface TokenService {

    AccessToken getToken(String appId, String appSecret);
}
