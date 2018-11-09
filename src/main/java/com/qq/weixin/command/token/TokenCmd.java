package com.qq.weixin.command.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.AccessToken;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TokenCmd extends Cmd<AccessToken> {

    private String appid;
    private String secret;

    public TokenCmd(String appid, String secret) {
        this.appid = appid;
        this.secret = secret;
    }

    @Override
    public boolean wrapToken() {
        return false;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        FormBody formBody = new FormBody.Builder()
                .add("grant_type", "client_credential")
                .add("appid", appid)
                .add("secret", secret).build();
        Request request = new Request.Builder()
                .url(BASE_URL + "token")
                .post(formBody)
                .build();
        return request;
    }

    @Override
    public AccessToken response(ObjectMapper mapper, Response response) throws IOException {
        return mapper.readValue(response.body().string(), AccessToken.class);
    }

}
