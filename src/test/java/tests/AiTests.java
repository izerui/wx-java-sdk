package tests;

import com.qq.weixin.command.ai.AddVoiceCmd;
import com.qq.weixin.command.ai.GetVoiceResultCmd;
import com.qq.weixin.command.ai.TranslateCmd;
import com.qq.weixin.mappings.LangEnum;
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
        System.out.println(voiceId);
    }

    @Test
    public void getResult() {
        String voiceId = "87841356-3cf7-402b-bc8a-628519d69501";
        String result = engine.execute(new GetVoiceResultCmd(voiceId, LangEnum.en_US), appId);
        System.out.println(result);
    }

    @Test
    public void translate() {
        String content = "you";
        String result = engine.execute(new TranslateCmd(content, LangEnum.en_US, LangEnum.zh_CH), appId);
        System.out.println(result);
    }
}
