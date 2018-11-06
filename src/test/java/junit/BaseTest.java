
package junit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.weixin.WxEngine;
import com.qq.weixin.api.AccessTokenApi;
import com.qq.weixin.mappings.AccessToken;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.Before;
import retrofit2.Response;

/**
 * Created by serv on 16/4/16.
 */
public abstract class BaseTest implements Constants {

    protected String accessToken;
    protected WxEngine engine;

    @Before
    public void setUp() throws Exception {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
                .build();
        engine = new WxEngine(client, new ObjectMapper());
        Response<AccessToken> execute = engine
                .proxy(AccessTokenApi.class)
                .getToken("client_credential", Constants.appId, Constants.appSecret)
                .execute();
        this.accessToken = execute.body().getAccessToken();
    }
}
