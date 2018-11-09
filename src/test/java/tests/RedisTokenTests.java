package tests;

import com.qq.weixin.IToken;
import com.qq.weixin.WxEngine;
import com.qq.weixin.command.groups.GetGroupsCmd;
import com.qq.weixin.mappings.Group;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class RedisTokenTests implements Constants {

    private IToken redisToken = new RedisToken(new HashMap() {{
        put(appId, appSecret);
        // ... more
    }});

    // 使用redis 存储 token,并设置有效时长
    private WxEngine wxEngine = new WxEngine(redisToken);


    @Test
    public void testGroups() {
        List<Group> groupList = wxEngine.execute(new GetGroupsCmd(), appId);
        System.out.println(groupList);
    }


}
