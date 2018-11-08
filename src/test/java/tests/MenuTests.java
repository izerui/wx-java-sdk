package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.IToken;
import com.qq.weixin.WxEngine;
import com.qq.weixin.command.menu.CreateMenuCmd;
import com.qq.weixin.command.menu.DeleteMenusCmd;
import com.qq.weixin.command.menu.GetMenusCmd;
import com.qq.weixin.mappings.Button;
import com.qq.weixin.mappings.Menu;
import com.qq.weixin.mappings.Status;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuTests implements Constants {

    protected WxEngine engine = new WxEngine(
            new ObjectMapper(),
            new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build(),
            new IToken.DefaultMapToken() {{
                setSecret(appId, appSecret);
            }});

    @Test
    public void create() throws IOException {

        List<Button> buttons = new ArrayList<Button>();

        Button button = new Button();
        button.setName("多大3331");
        button.setType(Button.ButtonType.click);
        button.setKey("jsjdf");
        buttons.add(button);

        Status status = engine.execute(new CreateMenuCmd(buttons), appId);
        System.out.println(status);
    }

    @Test
    public void get() throws IOException {
        List<Menu> buttons = engine.execute(new GetMenusCmd(),appId);
        System.out.println(buttons);
    }

    @Test
    public void delete() throws IOException {
        Status delete = engine.execute(new DeleteMenusCmd(),appId);
        System.out.println(delete);
    }


}
