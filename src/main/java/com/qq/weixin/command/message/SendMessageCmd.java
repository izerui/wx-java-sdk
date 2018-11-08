package com.qq.weixin.command.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.Message;
import com.qq.weixin.mappings.Status;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SendMessageCmd extends Cmd<Status> {

    private Message message;

    public SendMessageCmd(Message message) {
        this.message = message;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "message/custom/send")
                .post(RequestBody.create(JSON_TYPE, message.toJson().getBytes("UTF-8")))
                .build();
        return request;
    }

    @Override
    public Status response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), Status.class);
    }
}
