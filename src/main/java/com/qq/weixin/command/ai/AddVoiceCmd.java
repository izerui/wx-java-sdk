package com.qq.weixin.command.ai;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.VoiceStatus;
import okhttp3.*;

public class AddVoiceCmd extends Cmd<VoiceStatus> {

    private String voiceId;
    private byte[] bytes;
    private String lang;

    public AddVoiceCmd(String voiceId, byte[] bytes, String lang) {
        this.voiceId = voiceId;
        this.bytes = bytes;
        this.lang = lang;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        MultipartBody requestBody = new MultipartBody.Builder()
                .addPart(RequestBody.create(MediaType.parse("application/octet-stream"), bytes))
                .setType(MultipartBody.FORM)
                .build();

        HttpUrl url = HttpUrl.get(BASE_URL + "media/voice/addvoicetorecofortext")
                .newBuilder()
                .addQueryParameter("format", "mp3")
                .addQueryParameter("voice_id", voiceId)
                .addQueryParameter("lang", lang)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return request;
    }

    @Override
    public VoiceStatus response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), VoiceStatus.class);
    }
}
