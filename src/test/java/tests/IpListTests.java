package tests;

import com.qq.weixin.command.iplist.GetCallbackIpCmd;
import org.junit.Test;

import java.util.List;

public class IpListTests implements Constants {

    @Test
    public void ipListTest() {
        List<String> list = engine.execute(new GetCallbackIpCmd(), appId);
        System.out.println(list);
    }
}
