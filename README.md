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


1. 实例化一个token配置类单例(需要实现 com.qq.weixin.IToken 接口),默认提供实现: com.qq.weixin.IToken.DefaultMapToken
2. 实例化 WxEngine 单例,并注入token配置类单例对象
3. 通过 WxEngine 单例来执行接口请求 (具体参看: test包下示例)
