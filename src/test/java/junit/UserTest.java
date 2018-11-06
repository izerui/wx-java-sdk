
package junit;

import com.qq.weixin.api.UserApi;
import com.qq.weixin.mappings.*;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by serv on 16/4/21.
 */
public class UserTest extends BaseTest {

    @Test
    public void get() throws IOException {

        Users users = engine.proxy(UserApi.class).getUsers(null,accessToken).execute().body();
        System.out.println(users);
    }

    @Test
    public void move() throws IOException {
        Status move = engine.proxy(UserApi.class).moveOne(new OneUser(1,"oTDoKtx09l8il-jM1TtdeGs_fHT4"),accessToken).execute().body();
        System.out.println(move);
    }

    @Test
    public void getGroup() throws IOException {
        Integer userGroup = engine.proxy(UserApi.class).getGroup("oTDoKt-0csI5Phsl1TqpUiBKm_cw",accessToken).execute().body();
        System.out.println(userGroup);
    }

    @Test
    public void moveUsers() throws IOException {
        Status move = engine.proxy(UserApi.class).moveArray(new ArrayUser(1, "oTDoKtx09l8il-jM1TtdeGs_fHT4","oTDoKtyOsM5Eo7AIVTidlm6nXHtA"),accessToken).execute().body();
        System.out.println(move);
    }

    @Test
    public void updateRemark() throws IOException {
        Status hello = engine.proxy(UserApi.class).updateRemark(new UserRemark("oTDoKtx09l8il-jM1TtdeGs_fHT4", "哈喽"),accessToken).execute().body();
        System.out.println(hello);

    }

    @Test
    public void userInfo() throws IOException {
        UserInfo userInfo = engine.proxy(UserApi.class).userInfo("oTDoKtx09l8il-jM1TtdeGs_fHT4","zh_CN",accessToken).execute().body();
        System.out.println(userInfo);
    }

}
