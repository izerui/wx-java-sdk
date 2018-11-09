package com.qq.weixin.command.url;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.command.JMap;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ShortUrlCmd implements Cmd<String> {

    private String longUrl;

    public ShortUrlCmd(String longUrl) {
        this.longUrl = longUrl;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "shorturl")
                .post(RequestBody.create(JSON_TYPE, JMap.create("action", "long2short")
                        .node("long_url", longUrl).writeToBytes(mapper)))
                .build();
        return request;
    }

    @Override
    public String response(ObjectMapper mapper, Response response) throws Exception {
        JsonNode jsonNode = mapper.readTree(response.body().bytes());
        return jsonNode.path("short_url").asText();
    }
}
