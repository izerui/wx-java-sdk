package com.qq.weixin.command.media;

import com.qq.weixin.command.Cmd;
import com.qq.weixin.mappings.Media;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public abstract class BaseUploadCmd<T> extends Cmd<T> {

    protected MultipartBody getMultipartBody(Media media) {
        MultipartBody.Builder builder = new MultipartBody.Builder();

        builder.addFormDataPart("media", media.getFileName(), RequestBody.create(MediaType.parse("application/octet-stream"), media.getData()))
                .addPart(RequestBody.create(MediaType.parse("text/plain"), String.valueOf(media.getData().length)))
                .addFormDataPart("type", media.getType());

        if (media.getType().equals("video")) {
            builder.addFormDataPart("description",
                    String.format("{\"title\":\"%s\",\"introduction\":\"%s\"}",
                            media.getTitle(), media.getIntroduction()));
        }

        builder.setType(MultipartBody.FORM);
        return builder.build();
    }
}
