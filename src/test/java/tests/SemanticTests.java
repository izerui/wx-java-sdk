package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.IToken;
import com.qq.weixin.WxEngine;
import com.qq.weixin.command.semantic.SearchSemanticCmd;
import com.qq.weixin.mappings.Semantic;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by serv on 16/4/24.
 */
public class SemanticTests implements Constants {

    protected WxEngine engine = new WxEngine(
            new ObjectMapper(),
            new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build(),
            new IToken.DefaultMapToken() {{
                setSecret(appId, appSecret);
            }});

    @Test
    public void semantic() throws IOException {

        Semantic semantic = new Semantic();
        semantic.setQuery("查一下明天从北京到上海的南航机票");
        semantic.setCity("北京");
        semantic.setCategory("flight,hotel");
        semantic.setAppid("fff");
        semantic.setUid("234");

        String search = engine.execute(new SearchSemanticCmd(semantic), appId);
        System.out.println(search);
    }
}
