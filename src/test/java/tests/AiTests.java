package tests;

import com.qq.weixin.command.ai.AddVoiceCmd;
import com.qq.weixin.mappings.Media;
import com.qq.weixin.mappings.Status;
import com.qq.weixin.mappings.VoiceStatus;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

public class AiTests implements Constants {

    @Test
    public void addVioce() throws IOException {
        File file = new File("/www/aaaaa.mp3");
        VoiceStatus status = engine.execute(new AddVoiceCmd(UUID.randomUUID().toString(), Files.readAllBytes(file.toPath()), "en_US"), appId);
        System.out.println(status);
    }
}
