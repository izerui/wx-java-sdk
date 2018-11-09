package com.qq.weixin.command.ai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.LangEnum;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GetVoiceResultCmd implements Cmd<String> {

    private String voiceId;
    private LangEnum lang;

    public GetVoiceResultCmd(String voiceId, LangEnum lang) {
        this.voiceId = voiceId;
        this.lang = lang;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(HttpUrl.get(BASE_URL + "media/voice/queryrecoresultfortext")
                        .newBuilder()
                        .addQueryParameter("voice_id", voiceId)
                        .addQueryParameter("lang", lang.name())
                        .build())
                .post(RequestBody.create(JSON_TYPE, ""))
                .build();
        return request;
    }

    @Override
    public String response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), JsonNode.class).path("result").asText();
    }
}
