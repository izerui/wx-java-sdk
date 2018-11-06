
package junit;

import com.qq.weixin.api.QrcodeApi;
import com.qq.weixin.mappings.QrCode;
import com.qq.weixin.mappings.Ticket;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by serv on 16/4/24.
 */
public class QrcodeJunit extends BaseTest {

    @Test
    public void create() throws IOException {
        Ticket fff = engine.proxy(QrcodeApi.class).create(QrCode.forever("fff"),accessToken).execute().body();
        System.out.println(fff);

        System.out.println(engine.proxy(QrcodeApi.class).url(fff.getTicket()).request().url().url());
    }

    @Test
    public void create01() throws IOException {
        Ticket ticket = engine.proxy(QrcodeApi.class).create(QrCode.timeout(100, 222),accessToken).execute().body();
        System.out.println(ticket);

        System.out.println(engine.proxy(QrcodeApi.class).url(ticket.getTicket()).request().url().url());
    }
}
