package tests;

import com.qq.weixin.command.message.SendMessageCmd;
import com.qq.weixin.mappings.Message;
import com.qq.weixin.mappings.Status;
import org.junit.Test;

public class MessageTests implements Constants {

    @Test
    public void send() {
        String user = "oTDoKt-0csI5Phsl1TqpUiBKm_cw";

        Status status = engine.execute(new SendMessageCmd(Message.text(user, "textMessage").withKfAccount("ssss")), appId);
        Status status1 = engine.execute(new SendMessageCmd(Message.image(user, "23yT1I1LARXHi2qbBlnXRAcXxcwo-LFOpEOJkIziIRCe58rVuUnMzNlHEsodBk5Q")), appId);
        Status status2 = engine.execute(new SendMessageCmd(Message.voice(user, "NNC4FVUZIh0FzO2SrGa7njZKgm3scen4FQ0lqaEm2O84j8-y6gLxi2LDzFL-sDHG")), appId);
        Status status3 = engine.execute(new SendMessageCmd(Message.video(user, "PXG86UJVDfrKNoNwzEJ7hQbwjf8J_LDim68zDt4oMCBNFv5wb48Mn3TMZ9Dgn2pw", "23yT1I1LARXHi2qbBlnXRAcXxcwo-LFOpEOJkIziIRCe58rVuUnMzNlHEsodBk5Q", "斯威普", "宣传视频001")), appId);
        Status status4 = engine.execute(new SendMessageCmd(Message.articleNews(user, "测试图文消息", "说明1", "http://qq.com", "https://tfile.yj2025.com/8ddba74c-6257-4a19-9ba7-4c62574a19de.png?attname=%E8%8A%B12.png")), appId);
        Status status5 = engine.execute(new SendMessageCmd(Message.mediaIdNews(user, "zbgUo6Yw_w0Xc0-IWbsjT_2ywoEcYIRJw3ltDqXMTjQ")), appId);
    }
}
