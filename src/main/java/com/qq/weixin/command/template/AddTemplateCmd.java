package com.qq.weixin.command.template;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.command.JMap;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddTemplateCmd implements Cmd<String> {

    private String templateIdShort;

    public AddTemplateCmd(String templateIdShort) {
        this.templateIdShort = templateIdShort;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "template/api_add_template")
                .post(RequestBody.create(JSON_TYPE, JMap.create("template_id_short", templateIdShort).writeToBytes(mapper)))
                .build();
        return request;
    }

    @Override
    public String response(ObjectMapper mapper, Response response) throws Exception {
        JsonNode jsonNode = mapper.readValue(response.body().bytes(), JsonNode.class);
        return jsonNode.path("template_id").asText();
    }
}
