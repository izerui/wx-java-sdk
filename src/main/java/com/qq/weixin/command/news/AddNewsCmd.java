package com.qq.weixin.command.news;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.command.JMap;
import com.qq.weixin.mappings.News;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.List;

public class AddNewsCmd implements Cmd<String> {

    private List<News> newses;

    public AddNewsCmd(List<News> newses) {
        this.newses = newses;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "material/add_news")
                .post(RequestBody.create(JSON_TYPE, JMap.create("articles", newses).writeToBytes(mapper)))
                .build();
        return request;
    }

    @Override
    public String response(ObjectMapper mapper, Response response) throws Exception {
        JsonNode jsonNode = mapper.readTree(response.body().bytes());
        return jsonNode.path("media_id").asText();
    }
}
