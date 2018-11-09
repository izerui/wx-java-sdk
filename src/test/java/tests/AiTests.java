package tests;

import com.qq.weixin.command.ai.AddVoiceCmd;
import com.qq.weixin.command.ai.GetVoiceResultCmd;
import com.qq.weixin.mappings.LangEnum;
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
    public void addVoice() throws IOException {
        File file = new File("/www/aaaaa.mp3");
        String voiceId = UUID.randomUUID().toString();
        VoiceStatus status = engine.execute(new AddVoiceCmd(voiceId, Files.readAllBytes(file.toPath()), LangEnum.en_US), appId);
    }

    @Test
    public void getResult(){
        String voiceId = "0ebf2e93-489d-4b1c-897f-ac152a0239c4";
        String result = engine.execute(new GetVoiceResultCmd(voiceId, LangEnum.en_US), appId);
        System.out.println(result);
    }
}
