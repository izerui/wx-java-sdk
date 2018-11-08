package com.qq.weixin.command.media;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.Media;
import com.qq.weixin.mappings.MediaStatus;
import okhttp3.*;

public class UploadMediaCmd extends BaseUploadCmd<MediaStatus> {

    private Media media;

    public UploadMediaCmd(Media media) {
        this.media = media;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL+"media/upload")
                .post(getMultipartBody(media))
                .build();
        return request;
    }

    @Override
    public MediaStatus response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(),MediaStatus.class);
    }
}
