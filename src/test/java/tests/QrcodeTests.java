package tests;

import com.qq.weixin.IToken;
import com.qq.weixin.WxEngine;
import com.qq.weixin.command.qrcode.CreateQrcodeCmd;
import com.qq.weixin.mappings.QrCode;
import com.qq.weixin.mappings.Ticket;
import org.junit.Test;

import java.io.IOException;

public class QrcodeTests implements Constants {

    protected WxEngine engine = new WxEngine(
            new IToken.DefaultMapToken() {{
                setSecret(appId, appSecret);
            }});


    @Test
    public void create() throws IOException {
        Ticket ticket = engine.execute(new CreateQrcodeCmd(QrCode.forever("fff")), appId);
        Ticket ticket2 = engine.execute(new CreateQrcodeCmd(QrCode.timeout(100, 99)), appId);
        System.out.println(ticket);
        System.out.println(ticket2);

    }

}
