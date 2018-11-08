package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.IToken;
import com.qq.weixin.WxEngine;
import com.qq.weixin.command.news.AddNewsCmd;
import com.qq.weixin.mappings.News;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.Test;

import java.io.IOException;

public class NewsesTests implements Constants {
    protected WxEngine engine = new WxEngine(
            new ObjectMapper(),
            new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build(),
            new IToken.DefaultMapToken() {{
                setSecret(appId, appSecret);
            }});

    @Test
    public void addNews() throws IOException {
        News news = new News(
                "bootren",
                "zbgUo6Yw_w0Xc0-IWbsjT2f0mkMEkb-Wb7e07dy0yUM",
                "lyh",
                "djfjdsjfdsfdsf",
                1,
                "jdsfjdsjfjdsjf",
                "http://boot.ren"
        );
        String s = engine.execute(new AddNewsCmd(News.newses(news)), appId);
        System.out.println(s);
    }

}
