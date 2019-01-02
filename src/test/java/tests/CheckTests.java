package tests;

import com.qq.weixin.command.check.CheckCmd;
import com.qq.weixin.mappings.CheckResult;
import org.junit.Test;

public class CheckTests implements Constants {


    @Test
    public void testCheck() {
        CheckResult checkResult = engine.execute(new CheckCmd(), appId);
        System.out.println(checkResult);
    }

}
