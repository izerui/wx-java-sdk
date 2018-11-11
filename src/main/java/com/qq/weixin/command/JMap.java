package com.qq.weixin.command;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JMap {

    private final Map map = new HashMap();

    public static JMap create() {
        return new JMap();
    }

    public static JMap create(String key, Object value) {
        JMap jMap = new JMap();
        jMap.put(key, value);
        return jMap;
    }

    public JMap put(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

    public byte[] writeToBytes(ObjectMapper mapper) throws IOException {
        return mapper.writeValueAsBytes(this.map);
    }
}