package com.qq.weixin.command.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.Users;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class GetUsersCmd implements Cmd<Users> {

    private String nextOpenId;

    public GetUsersCmd(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }

    public GetUsersCmd() {
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(HttpUrl.get(BASE_URL + "user/get").newBuilder().addQueryParameter("next_openid", nextOpenId).build())
                .get()
                .build();
        return request;
    }

    @Override
    public Users response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), Users.class);
    }
}
