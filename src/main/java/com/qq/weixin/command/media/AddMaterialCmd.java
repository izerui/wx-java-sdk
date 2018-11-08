package com.qq.weixin.command.media;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.mappings.MaterialStatus;
import com.qq.weixin.mappings.Media;
import okhttp3.Request;
import okhttp3.Response;

public class AddMaterialCmd extends BaseUploadCmd<MaterialStatus> {

    private Media media;

    public AddMaterialCmd(Media media) {
        this.media = media;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL+"material/add_material")
                .post(getMultipartBody(media))
                .build();
        return request;
    }

    @Override
    public MaterialStatus response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(),MaterialStatus.class);
    }
}
