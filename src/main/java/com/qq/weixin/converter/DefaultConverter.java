package com.qq.weixin.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by serv on 16/4/23.
 */
public class DefaultConverter<REQ, RES> {

    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String CHARSET_GBK = "GBK";

    protected String charSetEncoding;

    public DefaultConverter() {
        this.charSetEncoding = CHARSET_UTF8;
    }

    public void setCharSetEncoding(String charSetEncoding) {
        this.charSetEncoding = charSetEncoding;
    }

    /**
     * 将入参对象转换成请求的requestBody字节数组
     *
     * @param objectMapper objectMapper对象
     * @param type         入参的Type类型
     * @param request      入参对象
     * @return http request请求的body字节数组
     * @throws IOException
     */
    public byte[] request(ObjectMapper objectMapper, Type type, REQ request) throws IOException {
        if (((Class) type).isAssignableFrom(String.class)) {
            return ((String) request).getBytes(charSetEncoding);
        }
        return objectMapper.writeValueAsBytes(request);
    }

    /**
     * 将responseBody字节数组 转换成 结果对象
     *
     * @param objectMapper objectMapper对象
     * @param type         结果对象的 Type类型
     * @param response     请求返回的responseBody字节数组
     * @return 返回 结果对象
     * @throws IOException
     */
    public RES response(ObjectMapper objectMapper, Type type, byte[] response) throws IOException {
        try {
            if (((Class) type).isAssignableFrom(String.class)) {
                return (RES) new String(response, charSetEncoding);
            }
            return (RES) objectMapper.readValue(response, Class.forName(type.getTypeName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected CollectionType getCollectionType(ObjectMapper objectMapper, Class tclass) {
        return objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, tclass);
    }

}
