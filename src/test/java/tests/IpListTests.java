package tests;

import com.qq.weixin.IToken;
import com.qq.weixin.WxEngine;
import com.qq.weixin.command.iplist.GetCallbackIpCmd;
import org.junit.Test;

import java.util.List;

public class IpListTests implements Constants {

    protected WxEngine engine = new WxEngine(
            new IToken.DefaultMapToken() {{
                setSecret(appId, appSecret);
            }});

    @Test
    public void ipListTest() {
        List<String> list = engine.execute(new GetCallbackIpCmd(), appId);
        System.out.println(list);
    }
}
