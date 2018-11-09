package com.qq.weixin.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

import java.util.ArrayList;

public interface Cmd<T> {

    MediaType JSON_TYPE = MediaType.parse("application/json;charset=utf-8");

    MediaType TEXT_TYPE = MediaType.parse("text/plain;charset=utf-8");

    String BASE_URL = "https://api.weixin.qq.com/cgi-bin/";

    Request request(ObjectMapper mapper) throws Exception;

    T response(ObjectMapper mapper, Response response) throws Exception;

    default CollectionType getCollectionType(ObjectMapper mapper, Class tclass) {
        return mapper.getTypeFactory().constructCollectionType(ArrayList.class, tclass);
    }

    // 是否需要附带accessToken
    default boolean wrapToken() {
        return true;
    }

    // 是否执行response返回前,检查errcode
    default boolean checkErrcode() {
        return true;
    }
}
