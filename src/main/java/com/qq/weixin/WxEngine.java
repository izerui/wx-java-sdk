
package com.qq.weixin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.interceptor.ErrorInterceptor;
import com.qq.weixin.interceptor.TokenInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by serv on 16/4/15.
 */
public final class WxEngine {

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
        this.wrapInterceptors();
    }

    // 包装client 的 token拦截器和错误码拦截器
    private void wrapInterceptors() {
        OkHttpClient.Builder builder = client.newBuilder();
        long tokenCount = builder.interceptors().stream().filter(interceptor -> interceptor instanceof TokenInterceptor).count();
        long errCount = builder.interceptors().stream().filter(interceptor -> interceptor instanceof ErrorInterceptor).count();
        if (tokenCount == 0L) {
            builder.addInterceptor(new TokenInterceptor(this));
        }
        if (errCount == 0L) {
            builder.addInterceptor(new ErrorInterceptor(this));
        }
        this.client = builder.build();
    }

    /**
     * 执行微信接口调用
     *
     * @param command 调用命令
     * @param appId   要使用的公众号的appId
     * @param <T>
     * @return
     */
    public <T> T execute(Cmd<T> command, String appId) {
        try {
            Request request = command
                    .request(mapper)
                    .newBuilder()
                    .tag(appId)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
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

    public ObjectMapper getMapper() {
        return mapper;
    }

    public IToken getIToken() {
        return iToken;
    }

}
