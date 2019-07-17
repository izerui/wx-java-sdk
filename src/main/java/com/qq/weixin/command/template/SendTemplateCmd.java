package com.qq.weixin.command.template;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.TemplateMsg;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SendTemplateCmd implements Cmd<Integer> {

    private TemplateMsg templateMsg;

    public SendTemplateCmd(TemplateMsg templateMsg) {
        this.templateMsg = templateMsg;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "message/template/send")
                .post(RequestBody.create(JSON_TYPE, mapper.writeValueAsBytes(templateMsg)))
                .build();
        return request;
    }

    @Override
    public Integer response(ObjectMapper mapper, Response response) throws Exception {
        JsonNode jsonNode = mapper.readValue(response.body().bytes(), JsonNode.class);
        return jsonNode.path("msgid").asInt();
    }
}
