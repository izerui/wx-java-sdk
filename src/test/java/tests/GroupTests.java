package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.IToken;
import com.qq.weixin.WxEngine;
import com.qq.weixin.command.groups.CreateGroupCmd;
import com.qq.weixin.command.groups.DeleteGroupCmd;
import com.qq.weixin.command.groups.GetGroupsCmd;
import com.qq.weixin.command.groups.UpdateGroupCmd;
import com.qq.weixin.mappings.Group;
import com.qq.weixin.mappings.Status;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class GroupTests implements Constants {

    protected WxEngine engine = new WxEngine(
            new ObjectMapper(),
            new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build(),
            new IToken.DefaultMapToken() {{
                setSecret(appId, appSecret);
            }});

    @Test
    public void testGroups() {
        List<Group> groupList = engine.execute(new GetGroupsCmd(), appId);
        System.out.println(groupList);
    }

    @Test
    public void createGroup() {
        for (int i = 0; i < 10; i++) {
            Group group = engine.execute(new CreateGroupCmd("发发发" + i), appId);
            System.out.println(group);
        }
    }

    @Test
    public void update() throws IOException {
        Status status = engine.execute(new UpdateGroupCmd(new Group(142, "aaa")), appId);
        System.out.println(status);
    }

    @Test
    public void delete() throws IOException {
        List<Group> groupList = engine.execute(new GetGroupsCmd(), appId);
        for (Group group : groupList) {
            if (group.getId() > 100) {
                Status delete = engine.execute(new DeleteGroupCmd(group.getId()), appId);
                System.out.println(delete);
            }
        }
    }
}
