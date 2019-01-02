package com.qq.weixin.command.check;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import com.qq.weixin.command.JMap;
import com.qq.weixin.mappings.CheckResult;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CheckCmd implements Cmd<CheckResult> {
    @Override
    public Request request(ObjectMapper mapper) throws Exception {
        Request request = new Request.Builder()
                .url(HttpUrl.get(BASE_URL + "callback/check"))
                .post(RequestBody.create(JSON_TYPE, JMap.create("action", "all").put("check_operator", "DEFAULT").writeToBytes(mapper)))
                .build();
        return request;
    }

    @Override
    public CheckResult response(ObjectMapper mapper, Response response) throws Exception {
        return mapper.readValue(response.body().bytes(), CheckResult.class);
    }
}
