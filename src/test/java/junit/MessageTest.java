
package junit;

import com.qq.weixin.api.MessageApi;
import com.qq.weixin.mappings.Message;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serv on 16/4/21.
 */
public class MessageTest extends BaseTest {

    @Test
    public void send() throws IOException {
        String user = "oTDoKt-0csI5Phsl1TqpUiBKm_cw";

        MessageApi messageApi = engine.proxy(MessageApi.class);

        System.out.println(messageApi.send(Message.text(user, "textMessage").withKfAccount("ssss"), accessToken).execute().body());
        System.out.println(messageApi.send(Message.image(user, "_h_qZqJeDHrZ-2GdgR4tsFGziVrntsefAN_MBZj8PKru4RpFqW4yrQMExpkAisok"), accessToken).execute().body());
        System.out.println(messageApi.send(Message.voice(user, "voiceMessage"), accessToken).execute().body());
        System.out.println(messageApi.send(Message.video(user, "voiceMessage", "djjdj", "djfjdf", "sdjfjsdf"), accessToken).execute().body());
        System.out.println(messageApi.send(Message.music(user, "voiceMessage", "djjdj", "djfjdf", "sdjfjsdf", "jdfj"), accessToken).execute().body());

        List<Message.Article> articles = new ArrayList<>();
        articles.add(new Message.Article("题名1", "说明1", "http://baidu.com", null));
        articles.add(new Message.Article("题名2", "说明2", "http://boot.ren", null));

        System.out.println(messageApi.send(Message.articleNews(user, articles), accessToken).execute().body());
        System.out.println(messageApi.send(Message.mediaIdNews(user, "zbgUo6Yw_w0Xc0-IWbsjT_2ywoEcYIRJw3ltDqXMTjQ"), accessToken).execute().body());
    }

    @Test
    public void send1() throws IOException {
        String user = "oTDoKt-0csI5Phsl1TqpUiBKm_cw";
        MessageApi messageService = engine.proxy(MessageApi.class);
        System.out.println(messageService.send(Message.mediaIdNews(user, "zbgUo6Yw_w0Xc0-IWbsjT_2ywoEcYIRJw3ltDqXMTjQ"), accessToken).execute().body());
    }
}
