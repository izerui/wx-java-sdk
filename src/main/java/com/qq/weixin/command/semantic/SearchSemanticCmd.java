package com.qq.weixin.command.semantic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.Semantic;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SearchSemanticCmd implements Cmd<String> {

    private Semantic semantic;

    public SearchSemanticCmd(Semantic semantic) {
        this.semantic = semantic;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url("https://api.weixin.qq.com/semantic/semproxy/search")
                .post(RequestBody.create(JSON_TYPE, mapper.writeValueAsBytes(semantic)))
                .build();
        return request;
    }

    @Override
    public String response(ObjectMapper mapper, Response response) throws Exception {
        return response.body().string();
    }
}
