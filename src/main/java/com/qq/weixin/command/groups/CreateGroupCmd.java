package com.qq.weixin.command.groups;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.command.JMap;
import com.qq.weixin.mappings.Group;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CreateGroupCmd extends Cmd<Group> {

    private String name;

    public CreateGroupCmd(String name) {
        this.name = name;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "groups/create")
                .post(RequestBody.create(JSON_TYPE, JMap.create("group", JMap.create("name", name)).writeToBytes(mapper)))
                .build();
        return request;
    }

    @Override
    public Group response(ObjectMapper mapper, Response response) throws Exception {
        JsonNode jsonNode = mapper.readTree(response.body().bytes());
        return mapper.readValue(jsonNode.path("group").toString(), Group.class);
    }
}
