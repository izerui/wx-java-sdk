package com.qq.weixin.command.template;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.command.JMap;
import com.qq.weixin.mappings.Status;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SetIndustryCmd implements Cmd<Status> {

    private String industryId1;
    private String industryId2;

    public SetIndustryCmd(String industryId1, String industryId2) {
        this.industryId1 = industryId1;
        this.industryId2 = industryId2;
    }

    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "template/api_set_industry")
                .post(RequestBody.create(JSON_TYPE, JMap.create("industry_id1", industryId1).put("industry_id2", industryId2).writeToBytes(mapper)))
                .build();
        return request;
    }

    @Override
    public Status response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), Status.class);
    }
}
