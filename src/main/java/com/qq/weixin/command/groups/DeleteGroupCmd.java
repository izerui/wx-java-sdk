package com.qq.weixin.command.groups;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.Status;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DeleteGroupCmd extends Cmd<Status> {

    private Integer groupId;

    public DeleteGroupCmd(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "groups/delete")
                .post(RequestBody.create(JSON_TYPE,JMap.create("group",JMap.create("id",groupId)).writeToBytes(mapper)))
                .build();
        return request;
    }

    @Override
    public Status response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), Status.class);
    }
}
