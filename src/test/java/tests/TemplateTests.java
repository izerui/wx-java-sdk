package tests;

import com.qq.weixin.command.template.GetIndustryCmd;
import com.qq.weixin.command.template.SetIndustryCmd;
import com.qq.weixin.command.url.ShortUrlCmd;
import com.qq.weixin.mappings.IndustryResult;
import com.qq.weixin.mappings.Status;
import org.junit.Test;

public class TemplateTests implements Constants {

    @Test
    public void set01(){
        Status execute = engine.execute(new SetIndustryCmd("2", "3"), appId);
        System.out.println(execute);
    }

    @Test
    public void get02(){
        IndustryResult result = engine.execute(new GetIndustryCmd(), appId);
        System.out.println(result);
    }
}
