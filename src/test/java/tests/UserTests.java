package tests;

import com.qq.weixin.IToken;
import com.qq.weixin.WxEngine;
import com.qq.weixin.command.users.GetGroupIdCmd;
import com.qq.weixin.command.users.GetUserInfoCmd;
import com.qq.weixin.command.users.GetUsersCmd;
import com.qq.weixin.mappings.*;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by serv on 16/4/21.
 */
public class UserTests implements Constants {

    protected WxEngine engine = new WxEngine(
            new IToken.DefaultMapToken() {{
                setSecret(appId, appSecret);
            }});

    @Test
    public void getUsers() throws IOException {
        Users users = engine.execute(new GetUsersCmd(), appId);
        System.out.println(users);
    }

    @Test
    public void getGroupId(){
        Integer execute = engine.execute(new GetGroupIdCmd("oTDoKtyOsM5Eo7AIVTidlm6nXHtA"), appId);
        System.out.println(execute);
    }

    @Test
    public void userInfo() throws IOException {
        UserInfo info = engine.execute(new GetUserInfoCmd("oTDoKtx09l8il-jM1TtdeGs_fHT4"), appId);
        System.out.println(info);
        System.out.println(info.getHeadImgUrl());

    }

}
