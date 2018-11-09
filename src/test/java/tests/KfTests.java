package tests;

import com.qq.weixin.command.kf.AddKfCmd;
import com.qq.weixin.mappings.KFSession;
import org.junit.Test;

public class KfTests implements Constants {

    @Test
    public void addKf() {
        KFSession kfSession = new KFSession();
        kfSession.setKFAccount("abc001");
        kfSession.setNickName("陈翔六点半");
        kfSession.setPassWord("123456");

        engine.execute(new AddKfCmd(kfSession), appId);
    }
}
