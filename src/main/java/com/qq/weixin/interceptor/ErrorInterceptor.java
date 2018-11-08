
package com.qq.weixin.interceptor;

import com.fasterxml.jackson.databind.JsonNode;
import com.qq.weixin.WxEngine;
import com.qq.weixin.WxException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by serv on 16/4/25.
 */
public class ErrorInterceptor implements Interceptor {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    private WxEngine engine;

    public ErrorInterceptor(WxEngine engine) {
        this.engine = engine;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        if(response.body().contentType() == null){
            return response;
        }
        if (response.body().contentType().toString().contains("application/json")) {
            BufferedSource source = response.body().source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            String body = buffer.clone().readString(UTF8);
            JsonNode jsonNode = engine.getMapper().readTree(body);
            if (jsonNode.has("errcode")) {
                String errcode = jsonNode.path("errcode").asText();
                if (errcode == null) {
                    throw new WxException("-1000", jsonNode.path("errmsg").asText());
                }
                if (!"0".equals(errcode)) {
                    //access_token 无效
                    if ("40001".equals(errcode)) {
                        engine.getIToken().deleteToken((String) request.tag());
                    }
                    throw new WxException(errcode, jsonNode.path("errmsg").asText());
                }
            }
        }
        return response;
    }
}
