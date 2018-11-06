
package junit;

import com.qq.weixin.api.GroupApi;
import com.qq.weixin.mappings.Group;
import com.qq.weixin.mappings.Status;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
public class GroupTest extends BaseTest {


    @Test
    public void test0() {
        System.out.println("s");
    }

    @Test
    public void groups() throws IOException {
        List<Group> groups = engine.proxy(GroupApi.class).groups(accessToken).execute().body();
        System.out.println(groups.toString());
    }

    @Test
    public void create() throws IOException {
        Group group = engine.proxy(GroupApi.class).create("ddd3333", accessToken).execute().body();
        System.out.println(group);
    }

    @Test
    public void update() throws IOException {
        Status update = engine.proxy(GroupApi.class).update(new Group(100, "123321123321"), accessToken).execute().body();
        System.out.println(update);
    }

    @Test
    public void delete() throws IOException {
        Status delete = engine.proxy(GroupApi.class).delete(106, accessToken).execute().body();
        System.out.println(delete);
    }

}
