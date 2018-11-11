package tests;

import com.qq.weixin.command.oraleval.OralevalCmd;
import org.junit.Test;
import sun.net.www.http.HttpClient;

public class OralevalTests implements Constants{


    @Test
    public void evalTest(){
        String execute = engine.execute(new OralevalCmd(), "");
        System.out.println(execute);
    }



}
