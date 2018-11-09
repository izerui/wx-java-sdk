package com.qq.weixin.command.ai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.WxException;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.LangEnum;
import okhttp3.*;

public class TranslateCmd implements Cmd<String> {

    private String content;
    private LangEnum lfrom;
    private LangEnum lto;

    public TranslateCmd(String content, LangEnum lfrom, LangEnum lto) {
        this.content = content;
        this.lfrom = lfrom;
        this.lto = lto;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        if(content.getBytes().length > 600){
            throw new WxException("-20009","大小超出范围");
        }
//        MultipartBody requestBody = new MultipartBody.Builder()
//                .addPart(RequestBody.create(MediaType.parse("text/plain"), content.getBytes("UTF-8")))
//                .setType(MultipartBody.FORM)
//                .build();

        Request request = new Request.Builder()
                .url(
                        HttpUrl.get(BASE_URL + "media/voice/translatecontent").newBuilder()
                                .addQueryParameter("lfrom", lfrom.name())
                                .addQueryParameter("lto", lto.name())
                                .build())
                .post(RequestBody.create(TEXT_TYPE,content))
                .build();
        return request;
    }

    @Override
    public String response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), JsonNode.class).path("to_content").asText();
    }
}
