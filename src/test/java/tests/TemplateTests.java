package tests;

import com.qq.weixin.command.template.GetAllTemplatesCmd;
import com.qq.weixin.command.template.GetIndustryCmd;
import com.qq.weixin.command.template.SendTemplateCmd;
import com.qq.weixin.command.template.SetIndustryCmd;
import com.qq.weixin.mappings.AllTemplates;
import com.qq.weixin.mappings.IndustryResult;
import com.qq.weixin.mappings.Status;
import com.qq.weixin.mappings.TemplateMsg;
import org.junit.Test;

import java.util.HashMap;

public class TemplateTests implements Constants {

    @Test
    public void set01() {
        Status execute = engine.execute(new SetIndustryCmd("2", "3"), appId);
        System.out.println(execute);
    }

    @Test
    public void get02() {
        IndustryResult result = engine.execute(new GetIndustryCmd(), appId);
        System.out.println(result);
    }

    @Test
    public void getAll() {
        AllTemplates templates = engine.execute(new GetAllTemplatesCmd(), appId);
        System.out.println(templates);
    }

    @Test
    public void sendTemplateMsg() {
        TemplateMsg msg = new TemplateMsg(
                "openId",
                "ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY",
                "http://weixin.qq.com/download",
                new TemplateMsg.Miniprogram("xiaochengxuappid12345", "index?foo=bar"),
                new HashMap<String, TemplateMsg.Keyword>() {{
                    put("first", new TemplateMsg.Keyword("恭喜你购买成功！", "#173177"));
                    put("first", new TemplateMsg.Keyword("巧克力", "#173177"));
                    put("first", new TemplateMsg.Keyword("39.8元", "#173177"));
                    put("first", new TemplateMsg.Keyword("2014年9月22日", "#173177"));
                    put("first", new TemplateMsg.Keyword("欢迎再次购买", "#173177"));
                }}

        );
        Integer msgId = engine.execute(new SendTemplateCmd(msg), appId);
        System.out.println(msgId);
    }
}
