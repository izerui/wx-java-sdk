package tests;

import com.qq.weixin.command.semantic.SearchSemanticCmd;
import com.qq.weixin.mappings.Semantic;
import org.junit.Test;

/**
 * Created by serv on 16/4/24.
 */
public class SemanticTests implements Constants {

    @Test
    public void semantic() {

        Semantic semantic = new Semantic();
        semantic.setQuery("查一下明天从北京到上海的南航机票");
        semantic.setCity("北京");
        semantic.setCategory("flight,hotel");
        semantic.setAppid("fff");
        semantic.setUid("234");

        String search = engine.execute(new SearchSemanticCmd(semantic), appId);
        System.out.println(search);
    }
}
