package com.qq.weixin.command.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.command.JMap;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GetGroupIdCmd implements Cmd<Integer> {

    private String openId;

    public GetGroupIdCmd(String openId) {
        this.openId = openId;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "groups/getid")
                .post(RequestBody.create(JSON_TYPE, JMap.create("openid", openId).writeToBytes(mapper)))
                .build();
        return request;
    }

    @Override
    public Integer response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readTree(response.body().bytes()).path("groupid").asInt();
    }
}
