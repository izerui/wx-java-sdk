package com.qq.weixin.command.groups;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.Group;
import com.qq.weixin.mappings.Status;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UpdateGroupCmd extends Cmd<Status> {

    private Group group;

    public UpdateGroupCmd(Group group) {
        this.group = group;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "groups/update")
                .post(RequestBody.create(JSON_TYPE, mapper.writeValueAsBytes(group)))
                .build();
        return request;
    }

    @Override
    public Status response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), Status.class);
    }
}
