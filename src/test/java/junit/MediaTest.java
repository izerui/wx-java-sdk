
package junit;

import com.qq.weixin.api.MediaApi;
import com.qq.weixin.mappings.MaterialStatus;
import com.qq.weixin.mappings.Media;
import com.qq.weixin.mappings.MediaStatus;
import com.qq.weixin.mappings.News;
import org.junit.Test;
import retrofit2.http.Url;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

/**
 * Created by serv on 16/4/25.
 */
public class MediaTest extends BaseTest {

    @Test
    public void upload() throws IOException {
        File file = new File("/www/90-0.jpg");
        Media media = Media.image("11.pic.jpg", Files.readAllBytes(file.toPath()));
        MediaStatus status = engine.proxy(MediaApi.class).upload(media.build(), media.getType(), accessToken).execute().body();
        System.out.println(status);
    }

    @Test
    public void uploadImg() throws IOException {
        File file = new File("/www/90-0.jpg");
        Media media = Media.image("11.pic.jpg", Files.readAllBytes(file.toPath()));
        String s = engine.proxy(MediaApi.class).uploadImg(media.build(),accessToken).execute().body();
        System.out.println(s);
    }


    @Test
    public void addMaterial() throws IOException {
        File file = new File("/www/90-0.jpg");
        Media media = Media.thumb("11.pic.jpg", Files.readAllBytes(file.toPath()));
        MaterialStatus materialStatus = engine.proxy(MediaApi.class).addMaterial(media.build(),accessToken).execute().body();
        System.out.println(materialStatus);
    }


    @Test
    public void url() throws IOException {
        URL df = engine.proxy(MediaApi.class).get("_h_qZqJeDHrZ-2GdgR4tsFGziVrntsefAN_MBZj8PKru4RpFqW4yrQMExpkAisok",accessToken).request().url().url();
        System.out.println(df);
    }

    @Test
    public void addNews() throws IOException {
        News news = new News(
                "bootren",
                "zbgUo6Yw_w0Xc0-IWbsjT2f0mkMEkb-Wb7e07dy0yUM",
                "lyh",
                "djfjdsjfdsfdsf",
                1,
                "jdsfjdsjfjdsjf",
                "http://boot.ren"
        );
        String s = engine.proxy(MediaApi.class).addNewses(News.newses(news),accessToken).execute().body();
        System.out.println(s);
    }
}
