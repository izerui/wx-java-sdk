package tests;

import com.qq.weixin.command.url.ShortUrlCmd;
import org.junit.Test;

/**
 * Created by serv on 16/4/24.
 */
public class ShortUrlTests implements Constants {

    @Test
    public void shortUrl() {
        String execute = engine.execute(new ShortUrlCmd("http://www.jsonschema2pojo.org"), appId);
        System.out.println(execute);
    }
}
