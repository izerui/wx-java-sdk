package com.qq.weixin.command.template;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.AllTemplates;
import okhttp3.Request;
import okhttp3.Response;

public class GetAllTemplatesCmd implements Cmd<AllTemplates> {
    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "template/get_all_private_template")
                .get()
                .build();
        return request;
    }

    @Override
    public AllTemplates response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), AllTemplates.class);
    }
}
