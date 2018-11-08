package tests;

import com.qq.weixin.IToken;
import com.qq.weixin.WxEngine;
import com.qq.weixin.command.url.ShortUrlCmd;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by serv on 16/4/24.
 */
public class ShortUrlTests implements Constants {

    protected WxEngine engine = new WxEngine(
            new IToken.DefaultMapToken() {{
                setSecret(appId, appSecret);
            }});

    @Test
    public void shortUrl() throws IOException {
        String execute = engine.execute(new ShortUrlCmd("http://www.jsonschema2pojo.org"), appId);
        System.out.println(execute);
    }
}
