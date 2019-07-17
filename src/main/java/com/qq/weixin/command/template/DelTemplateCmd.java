package com.qq.weixin.command.template;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.command.JMap;
import com.qq.weixin.mappings.Status;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DelTemplateCmd implements Cmd<Status> {

    private String templateId;

    public DelTemplateCmd(String templateId) {
        this.templateId = templateId;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "template/del_private_template")
                .post(RequestBody.create(JSON_TYPE, JMap.create("template_id", templateId).writeToBytes(mapper)))
                .build();
        return request;
    }

    @Override
    public Status response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(),Status.class);
    }
}
