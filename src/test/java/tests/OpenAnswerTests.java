package tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class OpenAnswerTests {

    private String cookie = "up_page_stime_100200=1556374428156; up_beacon_vist_count_100200=7; isGuide=false; up_page_stime_100200=1556375651839; up_beacon_vist_count_100200=11; __jsluid=9cffe1ef29a0a850b4a18d05dd8fa072; radius=14.103.74.214; up_page_stime_100200=1556371496395; up_beacon_vist_count_100200=1; b_t_s_100200=78b1f00f-e9ce-4cd6-97ce-ae1a629ba30d; up_first_date=2019-04-27; up_beacon_id_100200=78b1f00f-e9ce-4cd6-97ce-ae1a629ba30d-1556371496400; Hm_lvt_686401bd1a1f7184252b460af0f4337e=1556371497; _fmdata=mPuQrGes5pmQPed4qaKeqIQ%2BAyuk45tuOozCd1SHh7eK2X2NVKpu4oUQeTz1Wshl9MM%2FxzZtEaaAfS8i2NxTkw0XAoJD5JwBQe4yjCw4bss%3D; ASP.NET_SessionId=onjabolbbekfw4lynihrn3la; up_beacon_user_id_100200=liuyhopen1903; up_beacon_uni_id_100200=10004; NTKF_T2D_CLIENTID=guestCE6386B8-57AC-B609-86B9-5F2EFA8B310C; nTalk_CACHE_DATA={uid:kf_10225_ISME9754_guestCE6386B8-57AC-B6,tid:1556375075466241}; Hm_lvt_946766664d58c814a94301842a7a73fb=1556375076; Hm_lpvt_946766664d58c814a94301842a7a73fb=1556375076; badu=idu; Hm_lpvt_686401bd1a1f7184252b460af0f4337e=1556375669";

    // get 该地方返回所有作业列表
    // http://learn.open.com.cn/StudentCenter/MyWork/GetOnlineJsonAll?t=0.2601177278482374

    // get 根据作业列表里面的相关参数 请求点击跳转做作业页面， 跳转后就可以获取到key
    // http://learn.open.com.cn/StudentCenter/OnLineJob/Redirect?mode=1&courseExerciseID=0&submitCount=2&studentHomeworkId=006f32f7-c6a2-4863-9283-4ead1791f1ed

    // 马克思
//    private String testPaper = "http://learn.open.com.cn/StudentCenter/OnlineJob/DoHomework?courseExerciseId=0&key=d7bbb0aefb0bc5f6&studentHomeworkId=b93a771e-f2b4-4680-8bc5-397f11429667&_=1556386233016";

    // 计算机2
    private String testPaper = "http://learn.open.com.cn/StudentCenter/OnlineJob/DoHomework?courseExerciseId=0&key=7b265f5841adbdd9&studentHomeworkId=fe37f00f-3d35-4c90-ada9-fcd55e488b62&_=1556387530051";

    // 计算机
//    private String testPaper = "http://learn.open.com.cn/StudentCenter/OnlineJob/DoHomework?courseExerciseId=0&key=3bd53e5e81a1fa9c&studentHomeworkId=006f32f7-c6a2-4863-9283-4ead1791f1ed&_=1556383089886";

    //    private String questionId = "ddec230e-8299-46aa-9fcb-b881d3420ba8a";
//    private String questionId = "qes-4c0893fc-6bfa-4c8c-9952-1781b2b8e132";

    public void getAnswers(String itemBankId, String questionId) throws IOException {
        Request request = new Request.Builder()
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.108 Safari/537.36")
                .header("Cookie", cookie)
                .url("http://learn.open.com.cn/StudentCenter/OnlineJob/GetQuestionDetail?bust=1556386164136&itemBankId=" + itemBankId + "&questionId=" + questionId + "&_=1556386163650")
                .get()
                .build();
        Call call = new OkHttpClient().newCall(request);
        Response response = call.execute();
        String string = response.body().string();
        JsonNode ans = new ObjectMapper().readValue(string, JsonNode.class);
        String title = ans.path("data").path("I2").asText();
        System.out.println(title);
        JsonNode choices = ans.path("data").path("Choices");
        choices.elements().forEachRemaining(choice -> {
            boolean isCorrect = choice.path("IsCorrect").asBoolean();
            if (isCorrect) {
                System.out.print("√ ");
            } else {
                System.out.print("  ");
            }
            System.out.print(choice.path("I1").asText());
            System.out.print(" : ");
            System.out.print(choice.path("I2").asText());
            System.out.println();
        });
//        System.out.println("::::::::::::::::::" + string);
    }

    @Test
    public void getQuestions() throws IOException {
        Request request = new Request.Builder()
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.108 Safari/537.36")
                .header("Cookie", cookie)
                .url(testPaper)
                .get()
                .build();
        Call call = new OkHttpClient().newCall(request);
        Response response = call.execute();
        String string = response.body().string();
        JsonNode jsonNode = new ObjectMapper().readValue(string, JsonNode.class);
        JsonNode testPaperContent = jsonNode.path("data").path("TestPaperContent");
        String itemBankId = testPaperContent.path("Model").path("P3").asText();
        JsonNode path = testPaperContent.path("Sections");
        path.elements().forEachRemaining(s -> {
            System.out.println("--------------------" + s.path("Title").asText() + "------------------");
            AtomicReference<Integer> i = new AtomicReference<>(1);
            s.path("ItemID").elements().forEachRemaining(item -> {
                try {
                    System.out.print(i.getAndSet(i.get() + 1) + ". ");
                    getAnswers(itemBankId, item.asText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.println(item.asText());
            });
        });

//        System.out.println(string);

    }
}
