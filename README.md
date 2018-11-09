# 微信公众平台sdk (基于okHttp,支持指定公众号接口请求)

在你的项目中使用:

[![](https://jitpack.io/v/izerui/wx-java-sdk.svg)](https://jitpack.io/#izerui/wx-java-sdk)

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

```
<dependency>
    <groupId>com.github.izerui</groupId>
    <artifactId>wx-java-sdk</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```


```
private IToken token = new IToken.DefaultMapToken();
private WxEngine engine = new WxEngine(token);

public void sendMsg(){
    Message msg = Message.image(user, "23yT1I1LARXHi2qbBlnXRAcXxcwo-LFOpEOJkIziIRCe58rVuUnMzNlHEsodBk5Q");
    engine.execute(new SendMessageCmd(msg), appId)
}
```