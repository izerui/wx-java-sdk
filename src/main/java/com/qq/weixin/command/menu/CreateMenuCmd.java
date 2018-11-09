package com.qq.weixin.command.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.command.JMap;
import com.qq.weixin.mappings.Button;
import com.qq.weixin.mappings.Status;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.List;

public class CreateMenuCmd implements Cmd<Status> {

    private List<Button> buttons;

    public CreateMenuCmd(List<Button> buttons) {
        this.buttons = buttons;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "menu/create")
                .post(RequestBody.create(JSON_TYPE, JMap.create("button", buttons).writeToBytes(mapper)))
                .build();
        return request;
    }

    @Override
    public Status response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), Status.class);
    }
}
