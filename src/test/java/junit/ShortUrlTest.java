
package junit;

import com.qq.weixin.api.ShortUrlApi;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by serv on 16/4/24.
 */
public class ShortUrlTest extends BaseTest {

    @Test
    public void shortUrl() throws IOException {
        String s = engine.proxy(ShortUrlApi.class).shortUrl("http://www.jsonschema2pojo.org/",accessToken).execute().body();
        System.out.println(s);
    }
}
