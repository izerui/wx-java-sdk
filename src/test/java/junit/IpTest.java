
package junit;

import com.qq.weixin.api.IpApi;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by serv on 16/4/28.
 */
public class IpTest extends BaseTest {

    @Test
    public void getCallBackIps() throws IOException {

        List<String> callBackIps = engine.proxy(IpApi.class).getCallBackIps(accessToken).execute().body();
        System.out.println(callBackIps);
    }
}
