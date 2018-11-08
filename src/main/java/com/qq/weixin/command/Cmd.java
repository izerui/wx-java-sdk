package com.qq.weixin.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Cmd<T> {

    public final static MediaType JSON_TYPE = MediaType.parse("application/json;charset=utf-8");

    public final static String BASE_URL = "https://api.weixin.qq.com/cgi-bin/";

    public abstract Request request(ObjectMapper mapper) throws Exception;

    public abstract T response(ObjectMapper mapper, Response response) throws Exception;

    protected CollectionType getCollectionType(ObjectMapper mapper, Class tclass) {
        return mapper.getTypeFactory().constructCollectionType(ArrayList.class, tclass);
    }

    protected Map<String, Object> node(String key, Object value) {
        Map<String, Object> jMap = new HashMap<>();
        jMap.put(key, value);
        return jMap;
    }

    public static class JMap extends HashMap<String, Object> {

        public static JMap create() {
            return new JMap();
        }

        public static JMap create(String key, Object value) {
            JMap jMap = new JMap();
            jMap.node(key,value);
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
