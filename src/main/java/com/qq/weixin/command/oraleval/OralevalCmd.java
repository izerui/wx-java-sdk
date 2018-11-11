package com.qq.weixin.command.oraleval;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.command.Cmd;
import okhttp3.*;

import java.io.File;
import java.util.UUID;

public class OralevalCmd implements Cmd<String> {
    @Override
    public Request request(ObjectMapper mapper) throws Exception {

        String file_str = "/www/aaaaa.mp3";

        MultipartBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("mode","A")
                .addFormDataPart("text","hello, i am nice to meet you")
                .addFormDataPart("voice",null,RequestBody.create(MediaType.parse("multipart/form-data"), new File(file_str)))
                .build();

        Request request = new Request.Builder()
//                .url("https://edu.hivoice.cn/eval/mp3")
                .url("http://edu.hivoice.cn:8085/eval/mp3")
                .header("appkey","usw35z47scrnnxshlyv7fenrrfoulot2jqfh4mi2")
                .header("session-id", UUID.randomUUID().toString())
                .header("device-id","device-id-001")
                .post(requestBody)
                .build();
        return request;
    }

    @Override
    public String response(ObjectMapper mapper, Response response) throws Exception {
        return response.body().string();
    }

    @Override
    public boolean wrapToken() {
        return false;
    }

    @Override
    public boolean checkErrcode() {
        return false;
    }
}
