package com.qq.weixin.command.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.UserInfo;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class GetUserInfoCmd extends Cmd<UserInfo> {

    private String openId;

    public GetUserInfoCmd(String openId) {
        this.openId = openId;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(HttpUrl.get(BASE_URL+"user/info").newBuilder()
                        .addQueryParameter("openid",openId)
                        .addQueryParameter("lang","zh_CN").build())
                .get()
                .build();
        return request;
    }

    @Override
    public UserInfo response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(),UserInfo.class);
    }
}
