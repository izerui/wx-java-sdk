package com.qq.weixin.command.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.Status;
import okhttp3.Request;
import okhttp3.Response;

public class DeleteMenusCmd extends Cmd<Status> {
    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "menu/delete")
                .get()
                .build();
        return request;
    }

    @Override
    public Status response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), Status.class);
    }
}
