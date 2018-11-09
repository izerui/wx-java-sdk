
package com.qq.weixin;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.command.token.TokenCmd;
import com.qq.weixin.mappings.AccessToken;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by serv on 16/4/15.
 */
public final class WxEngine {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    private ObjectMapper mapper;
    private OkHttpClient client;
    private IToken iToken;

    public WxEngine(IToken iToken) {
        this(new ObjectMapper(), new OkHttpClient(), iToken);
    }

    public WxEngine(ObjectMapper mapper, OkHttpClient client, IToken iToken) {
        this.mapper = mapper;
        this.client = client;
        this.iToken = iToken;
    }

    /**
     * 执行微信公众平台接口调用
     *
     * @param command 调用命令
     * @param appId   要使用的公众号的appId
     * @param <T>
     * @return
     */
    public <T> T execute(Cmd<T> command, String appId) {
        try {
            Request request = this.wrapToken(command, appId);
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                if (command.checkErrcode()) {
                    checkErrcode(response, appId);
                }
                return command.response(mapper, response);
            } else {
                throw new WxException("-10001", "Unexpected code" + response);
            }
        } catch (Exception ex) {
            if (ex instanceof WxException) {
                throw (WxException) ex;
            }
            throw new WxException("-10000", ex.getMessage(), ex);
        }
    }

    private void checkErrcode(Response response, String appId) throws IOException {
        BufferedSource source = response.body().source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        String body = buffer.clone().readString(UTF8);
        JsonNode jsonNode = mapper.readTree(body);
        if (jsonNode.has("errcode")) {
            String errcode = jsonNode.path("errcode").asText();
            if (errcode == null) {
                throw new WxException("-1000", jsonNode.path("errmsg").asText());
            }
            if (!"0".equals(errcode)) {
                //access_token 无效
                if ("40001".equals(errcode)) {
                    iToken.deleteToken(appId);
                }
                throw new WxException(errcode, jsonNode.path("errmsg").asText());
            }
        }
    }

    private Request wrapToken(Cmd command, String appId) throws Exception {
        Request request = command.request(mapper);
        if (command.wrapToken()) {
            HttpUrl url = HttpUrl.get(request.url().url())
                    .newBuilder()
                    .addQueryParameter("access_token", getToken(appId))
                    .build();
            request = request.newBuilder().url(url).build();
        }
        return request;
    }

    private String getToken(String appId) {
        String token = this.iToken.getToken(appId);
        if (token == null) {
            String secret = this.iToken.getSecret(appId);
            if (secret == null) {
                throw new WxException("-20002", "未找到appId和secret相关配置");
            }
            AccessToken accessToken = this.execute(new TokenCmd(appId, secret), appId);
            this.iToken.updateToken(appId, accessToken);
            return accessToken.getAccessToken();
        }
        return token;
    }

}
