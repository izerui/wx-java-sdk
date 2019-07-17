package com.qq.weixin.command.template;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.IndustryResult;
import okhttp3.Request;
import okhttp3.Response;

public class GetIndustryCmd implements Cmd<IndustryResult> {
    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "template/get_industry")
                .get()
                .build();
        return request;
    }

    @Override
    public IndustryResult response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), IndustryResult.class);
    }
}
