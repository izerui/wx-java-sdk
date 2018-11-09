package com.qq.weixin.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Cmd<T> {

    public final static MediaType JSON_TYPE = MediaType.parse("application/json;charset=utf-8");

    public final static String BASE_URL = "https://api.weixin.qq.com/cgi-bin/";

    public abstract Request request(ObjectMapper mapper) throws Exception;

    public abstract T response(ObjectMapper mapper, Response response) throws Exception;

    protected CollectionType getCollectionType(ObjectMapper mapper, Class tclass) {
        return mapper.getTypeFactory().constructCollectionType(ArrayList.class, tclass);
    }

    // 是否需要附带accessToken
    public boolean wrapToken() {
        return true;
    }

    public static class JMap extends HashMap<String, Object> {

        public static JMap create() {
            return new JMap();
        }

        public static JMap create(String key, Object value) {
            JMap jMap = new JMap();
            jMap.node(key, value);
            return jMap;
        }

        public JMap node(String key, Object value) {
            this.put(key, value);
            return this;
        }

        public byte[] writeToBytes(ObjectMapper mapper) throws IOException {
            return mapper.writeValueAsBytes(this);
        }
    }
}
