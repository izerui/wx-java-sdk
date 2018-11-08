
package com.qq.weixin.interceptor;

import com.qq.weixin.WxEngine;
import com.qq.weixin.WxException;
import com.qq.weixin.command.token.TokenCmd;
import com.qq.weixin.mappings.AccessToken;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by serv on 16/4/25.
 */
public class TokenInterceptor implements Interceptor {

    private WxEngine engine;

    public TokenInterceptor(WxEngine engine) {
        this.engine = engine;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (request.url().url().toString().startsWith("https://api.weixin.qq.com/cgi-bin/token")) {
            return chain.proceed(request);
        }
        HttpUrl url = HttpUrl.get(request.url().url()).newBuilder().addQueryParameter("access_token", getToken((String) request.tag())).build();
        Response response = chain.proceed(request.newBuilder().url(url).build());
        return response;
    }

    private String getToken(String appId) {
        String token = engine.getIToken()
                .getToken(appId);
        if (token == null) {
            String secret = engine.getIToken().getSecret(appId);
            if (secret == null) {
                throw new WxException("-20002", "未找到appId和secret相关配置");
            }
            AccessToken accessToken = engine.execute(new TokenCmd(appId, secret), appId);
            engine.getIToken().updateToken(appId, accessToken);
            return accessToken.getAccessToken();
        }
        return token;
    }
}
