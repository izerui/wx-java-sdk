
package junit;

import com.qq.weixin.api.MenuApi;
import com.qq.weixin.mappings.Button;
import com.qq.weixin.mappings.Menu;
import com.qq.weixin.mappings.Status;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serv on 16/4/16.
 */
public class MenuTest extends BaseTest {

    @Test
    public void create() throws IOException {

        List<Button> buttons = new ArrayList<Button>();

        Button button = new Button();
        button.setName("多大3331");
        button.setType(Button.ButtonType.click);
        button.setKey("jsjdf");
        buttons.add(button);

        Status status = engine.proxy(MenuApi.class).create(buttons,accessToken).execute().body();
        System.out.println(status.getErrMsg());
    }

    @Test
    public void get() throws IOException {
        List<Menu> buttons = engine.proxy(MenuApi.class).get(accessToken).execute().body();
        System.out.println(buttons);
    }

    @Test
    public void delete() throws IOException {
        Status delete = engine.proxy(MenuApi.class).delete(accessToken).execute().body();
        System.out.println(delete);
    }

}
