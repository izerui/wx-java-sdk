package tests;

import com.qq.weixin.command.news.AddNewsCmd;
import com.qq.weixin.mappings.News;
import org.junit.Test;

public class NewsesTests implements Constants {

    @Test
    public void addNews() {
        News news = new News(
                "bootren",
                "zbgUo6Yw_w0Xc0-IWbsjT2f0mkMEkb-Wb7e07dy0yUM",
                "lyh",
                "djfjdsjfdsfdsf",
                1,
                "jdsfjdsjfjdsjf",
                "http://boot.ren"
        );
        String s = engine.execute(new AddNewsCmd(News.newses(news)), appId);
        System.out.println(s);
    }

}
