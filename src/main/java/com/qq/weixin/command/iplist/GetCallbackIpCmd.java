package com.qq.weixin.command.iplist;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import okhttp3.Request;
import okhttp3.Response;

import java.util.List;

public class GetCallbackIpCmd implements Cmd<List<String>> {
    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL+"getcallbackip")
                .get()
                .build();
        return request;
    }

    @Override
    public List<String> response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(mapper.readTree(response.body().bytes()).path("ip_list").toString(), getCollectionType(mapper, String.class));
    }
}
