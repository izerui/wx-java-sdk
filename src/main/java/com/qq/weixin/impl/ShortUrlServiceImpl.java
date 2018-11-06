
package com.qq.weixin.impl;

import com.qq.weixin.ShortUrlService;
import com.qq.weixin.api.ShortUrlApi;
import retrofit2.Retrofit;

/**
 * Created by serv on 16/4/24.
 */
public class ShortUrlServiceImpl extends ServiceImpl<ShortUrlApi> implements ShortUrlService {

    public ShortUrlServiceImpl(Retrofit retrofit) {
        super(retrofit);
    }

    @Override
    protected Class<ShortUrlApi> getApiClass() {
        return ShortUrlApi.class;
    }

    @Override
    public String shortUrl(String longUrl) {
        return execute(api().shortUrl(longUrl,accessToken));
    }
}
