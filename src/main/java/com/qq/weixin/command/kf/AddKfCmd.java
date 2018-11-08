package com.qq.weixin.command.kf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.KFSession;
import com.qq.weixin.mappings.Status;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddKfCmd extends Cmd<Status> {

    private KFSession kfSession;

    public AddKfCmd(KFSession kfSession) {
        this.kfSession = kfSession;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url("https://api.weixin.qq.com/customservice/kfaccount/add")
                .post(RequestBody.create(JSON_TYPE, mapper.writeValueAsBytes(kfSession)))
                .build();
        return request;
    }

    @Override
    public Status response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), Status.class);
    }
}
