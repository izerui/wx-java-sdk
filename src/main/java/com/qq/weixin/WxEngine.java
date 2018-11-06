
package com.qq.weixin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.converter.ConverterFactory;
import com.qq.weixin.interceptor.ErrCodeInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by serv on 16/4/15.
 */
public final class WxEngine {

    private Retrofit retrofit;

    public WxEngine() {
        this(new OkHttpClient(), new ObjectMapper());
    }

    public WxEngine(OkHttpClient client, ObjectMapper objectMapper) {
        OkHttpClient newClient = client.newBuilder().addInterceptor(new ErrCodeInterceptor(objectMapper)).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weixin.qq.com/cgi-bin/")
                .client(newClient)
                .addConverterFactory(new ConverterFactory(objectMapper)).build();
    }

    public <T> T proxy(Class<T> tClass) {
        if (tClass == null) {
            throw new WxException("-999", "api class must not be null!");
        }
        return retrofit.create(tClass);
    }

}
