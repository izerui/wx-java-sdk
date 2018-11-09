package tests;

import com.qq.weixin.command.qrcode.CreateQrcodeCmd;
import com.qq.weixin.mappings.QrCode;
import com.qq.weixin.mappings.Ticket;
import org.junit.Test;

public class QrcodeTests implements Constants {


    @Test
    public void create() {
        Ticket ticket = engine.execute(new CreateQrcodeCmd(QrCode.forever("fff")), appId);
        Ticket ticket2 = engine.execute(new CreateQrcodeCmd(QrCode.timeout(100, 99)), appId);
        System.out.println(ticket);
        System.out.println(ticket2);

    }

}
