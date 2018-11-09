package com.qq.weixin.command;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class JMap extends HashMap<String, Object> {

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