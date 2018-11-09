
package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.IToken;
import com.qq.weixin.WxEngine;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by serv on 16/4/16.
 */
public interface Constants {
    String appId = "wx9875533e72bb7a15";
    String appSecret = "76c7c9a8f85ddd4bd4d3739d1a60f0bf";

    Map<String,String> apps = new HashMap() {{
        put(appId, appSecret);
        // ...放入更多的appId和秘钥
    }};

    IToken token = new IToken.DefaultMapToken(apps);

    WxEngine engine = new WxEngine(
            new ObjectMapper(),
            new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build(),
            token);
}
