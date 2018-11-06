
package junit;

import com.qq.weixin.api.SemanticApi;
import com.qq.weixin.mappings.Semantic;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by serv on 16/4/24.
 */
public class SemanticTest extends BaseTest {

    @Test
    public void semantic() throws IOException {

        Semantic semantic = new Semantic();
        semantic.setQuery("查一下明天从北京到上海的南航机票");
        semantic.setCity("北京");
        semantic.setCategory("flight,hotel");
        semantic.setAppid("fff");
        semantic.setUid("234");

        String search = engine.proxy(SemanticApi.class).search(semantic,accessToken).execute().body();
        System.out.println(search);
    }
}
