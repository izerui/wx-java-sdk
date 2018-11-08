package tests;

import com.qq.weixin.IToken;
import com.qq.weixin.WxEngine;
import com.qq.weixin.command.groups.GetGroupsCmd;
import com.qq.weixin.mappings.Group;
import org.junit.Test;

import java.util.List;

public class RedisTokenTests implements Constants {

    private IToken redisToken = new RedisToken() {{
        setSecret(appId, appSecret);
    }};

    // 使用redis 存储 token,并设置有效时长
    protected WxEngine engine = new WxEngine(redisToken);


    @Test
    public void testGroups() {
        List<Group> groupList = engine.execute(new GetGroupsCmd(), appId);
        System.out.println(groupList);
    }


}
