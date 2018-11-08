package com.qq.weixin.command.media;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.mappings.Media;
import okhttp3.Request;
import okhttp3.Response;

public class UploadImgCmd extends BaseUploadCmd<String> {

    private Media media;

    public UploadImgCmd(Media media) {
        this.media = media;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL+"media/uploadimg")
                .post(getMultipartBody(media))
                .build();
        return request;
    }

    @Override
    public String response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readTree(response.body().bytes()).path("url").asText();
    }
}
