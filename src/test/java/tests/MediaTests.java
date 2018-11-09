package tests;

import com.qq.weixin.command.media.AddMaterialCmd;
import com.qq.weixin.command.media.UploadImgCmd;
import com.qq.weixin.command.media.UploadMediaCmd;
import com.qq.weixin.mappings.MaterialStatus;
import com.qq.weixin.mappings.Media;
import com.qq.weixin.mappings.MediaStatus;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MediaTests implements Constants {

    @Test
    public void upload() throws IOException {
        File file = new File("/www/90-0.jpg");
        Media media = Media.image("11.pic.jpg", Files.readAllBytes(file.toPath()));
        MediaStatus status = engine.execute(new UploadMediaCmd(media), appId);
        System.out.println(status);
    }

    @Test
    public void uploadVioce() throws IOException {
        File file = new File("/www/window_min.mp3");
        Media media = Media.voice("window_min.mp3", Files.readAllBytes(file.toPath()));
        MediaStatus status = engine.execute(new UploadMediaCmd(media), appId);
        System.out.println(status);
    }

    @Test
    public void uploadVideo() throws IOException {
        File file = new File("/www/1541641996821060.mp4");
        Media media = Media.video("1541641996821060.mp4","斯威普", "宣传视频",Files.readAllBytes(file.toPath()));
        MediaStatus status = engine.execute(new UploadMediaCmd(media), appId);
        System.out.println(status);
    }

    @Test
    public void uploadImg() throws IOException {
        File file = new File("/www/90-0.jpg");
        Media media = Media.image("11.pic.jpg", Files.readAllBytes(file.toPath()));
        String url = engine.execute(new UploadImgCmd(media), appId);
        System.out.println(url);
    }

    @Test
    public void addMaterial() throws IOException {
        File file = new File("/www/90-0.jpg");
        Media media = Media.thumb("11.pic.jpg", Files.readAllBytes(file.toPath()));
        MaterialStatus materialStatus = engine.execute(new AddMaterialCmd(media), appId);
        System.out.println(materialStatus);
    }

}
